package psc_team.psc.container;

import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import psc_team.psc.entity.tile.TileEntityDehydrator;
import psc_team.psc.recipes.DehydratorRecipes;

/**
 * @author The_Fireplace
 */
public class SlotFuel extends Slot {
	TileEntityDehydrator inv;

	public SlotFuel(TileEntityDehydrator inventoryIn, int index, int xPosition,
						   int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		inv=inventoryIn;
	}
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return DehydratorRecipes.instance().isFuel(stack);
	}
	@Override
	public void putStack(ItemStack stack)
	{
		if(stack != null){
			this.inventory.setInventorySlotContents(this.getSlotIndex(), stack);
			inv.addToFuel(GameRegistry.getFuelValue(stack));
			this.inventory.setInventorySlotContents(getSlotIndex(), null);
		}
	}
}