package psc_team.psc.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * @author The_Fireplace
 */
public class SlotDehydratorOutput extends Slot {

	public SlotDehydratorOutput(IInventory inventoryIn, int index,
							   int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return false;
	}
}
