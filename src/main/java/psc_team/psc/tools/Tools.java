package psc_team.psc.tools;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

/**
 * @author The_Fireplace
 */
public class Tools {
	public static boolean areItemStacksEqual(ItemStack is1, ItemStack is2){
		return is2.getItem() == is1.getItem() && (is2.getMetadata() == 32767 || is2.getMetadata() == is1.getMetadata());
	}
	public static void spawnItemAtPlayer(EntityPlayer player, ItemStack stack){
		if(!player.worldObj.isRemote){
			if(player instanceof FakePlayer || !player.inventory.addItemStackToInventory(stack)){
				EntityItem entityitem = new EntityItem(player.worldObj, player.posX+0.5D, player.posY+0.5D, player.posZ+0.5D, stack);
				player.worldObj.spawnEntityInWorld(entityitem);
				if(!(player instanceof FakePlayer))
					entityitem.onCollideWithPlayer(player);
			}else{
				if(player instanceof EntityPlayerMP){
					player.worldObj.playSoundAtEntity(player, "random.pop", 0.2F, player.worldObj.rand.nextFloat());
					player.inventoryContainer.detectAndSendChanges();
				}
			}
		}
	}
	public static void spawnItemAtPos(ItemStack stack, World world, BlockPos pos){
		EntityItem entityitem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		if(!world.isRemote)
			world.spawnEntityInWorld(entityitem);
	}
}
