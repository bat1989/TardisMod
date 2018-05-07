package net.tardis.mod.packets;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.tardis.api.protocols.TardisProtocol;
import net.tardis.mod.common.tileentity.TileEntityTardis;

public class MessageHandlerProtocol implements IMessageHandler<MessageProtocol, IMessage> {
	
	@Override
	public IMessage onMessage(MessageProtocol mes, MessageContext ctx) {
		ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable() {
			@Override
			public void run() {
				WorldServer ws = ctx.getServerHandler().player.getServerWorld();
				TileEntity te = ws.getTileEntity(mes.consolePos);
				if (te != null && te instanceof TileEntityTardis) {
					TardisProtocol.getProtocolFromId(mes.id).onActivated(ws, (TileEntityTardis) te);
					System.out.println(mes.id);
				}
			}
		});
		return null;
	}
	
}
