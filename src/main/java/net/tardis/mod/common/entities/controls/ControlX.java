package net.tardis.mod.common.entities.controls;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.tardis.mod.common.tileentity.TileEntityTardis;
import net.tardis.mod.common.tileentity.consoles.TileEntityTardis01;
import net.tardis.mod.common.tileentity.consoles.TileEntityTardis02;
import net.tardis.mod.util.common.helpers.Helper;

public class ControlX extends EntityControl {
	
	public ControlX(TileEntityTardis tardis) {
		super(tardis);
	}
	
	public ControlX(World world) {
		super(world);
		this.setSize(0.0625F, 0.0625F);
	}
	
	@Override
	public Vec3d getOffset(TileEntityTardis tardis) {
		if(tardis.getClass() == TileEntityTardis01.class || tardis.getClass() == TileEntityTardis02.class) {
			return Helper.convertToPixels(1, -2.5, -13.5);
		}
		return Helper.convertToPixels(-8, -0.5, 3.5);
	}
	
	@Override
	public void preformAction(EntityPlayer player) {
		if (!world.isRemote) {
			TileEntityTardis tardis = ((TileEntityTardis) world.getTileEntity(this.getConsolePos()));
			tardis.setDesination(tardis.getDestination().add(player.isSneaking() ? -tardis.magnitude : tardis.magnitude, -1, 0), tardis.getTargetDim());
		} else if (this.ticks <= 0) {
			this.ticks = 20;
			this.direction = player.isSneaking() ? -1 : 1;
		}
	}
	
}
