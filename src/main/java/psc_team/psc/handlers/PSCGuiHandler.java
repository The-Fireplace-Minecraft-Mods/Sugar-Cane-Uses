package psc_team.psc.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import psc_team.psc.container.ContainerDehydrator;
import psc_team.psc.entity.tile.TileEntityDehydrator;
import psc_team.psc.gui.GuiDehydrator;

/**
 * @author The_Fireplace
 */
public class PSCGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
									  int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		switch(ID){
			case 0:
				if(entity != null && entity instanceof TileEntityDehydrator){
					return new ContainerDehydrator(player.inventory, (TileEntityDehydrator)entity);
				}else{
					return null;
				}
			default: return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
									  int x, int y, int z) {
		TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
		switch(ID){
			case 0:
				if(entity != null && entity instanceof TileEntityDehydrator){
					return new GuiDehydrator(player.inventory, (TileEntityDehydrator)entity);
				}else{
					return null;
				}
			default: return null;
		}
	}

}