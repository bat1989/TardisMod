package net.tardis.mod.client.worldshell;

import java.util.Map.Entry;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSyncWorldShell implements IMessage {
	//Sync the world shell from client to server

	public WorldShell worldShell;
	public int id;
	
	public MessageSyncWorldShell(WorldShell ws, int id) {
		this.id = id;
		worldShell = ws;
	}
	
	public MessageSyncWorldShell() {}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.id = buf.readInt();
		int s = buf.readInt();
		worldShell = new WorldShell(BlockPos.fromLong(buf.readLong()));
		for (int i = 0; i < s; ++i) {
			BlockPos bp = BlockPos.fromLong(buf.readLong());
			BlockStorage bs = new BlockStorage();
			bs.fromBuf(buf);
			worldShell.blockMap.put(bp, bs);
		}
		worldShell.setTESRs();
		worldShell.updateRequired = true;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
		buf.writeInt(worldShell.blockMap.size());
		buf.writeLong(worldShell.getOffset().toLong());
		for(Entry<BlockPos,BlockStorage> e:worldShell.blockMap.entrySet()) {
			buf.writeLong(e.getKey().toLong());
			e.getValue().toBuf(buf);
		}
	}
	
	public static class Handler implements IMessageHandler<MessageSyncWorldShell, IMessage> {

		public Handler() {}
		
		@Override
		public IMessage onMessage(MessageSyncWorldShell mes, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(new Runnable() {
				@Override
				public void run() {
					World world = Minecraft.getMinecraft().world;
					Entity entity = world.getEntityByID(mes.id);
					if(entity != null && entity instanceof IContainsWorldShell){
						((IContainsWorldShell)entity).setWorldShell(mes.worldShell);
					}
				}});
			return null;
		}

	}

}