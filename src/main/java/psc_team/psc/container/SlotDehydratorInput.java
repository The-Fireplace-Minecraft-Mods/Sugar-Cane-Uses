package psc_team.psc.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import psc_team.psc.recipes.DehydratorRecipes;
import psc_team.psc.tools.Tools;

import java.util.Iterator;
import java.util.Map;

/**
 * @author The_Fireplace
 */
public class SlotDehydratorInput extends Slot {

	public SlotDehydratorInput(IInventory inventoryIn, int index,
							   int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		Iterator iterator = DehydratorRecipes.instance().getDehydratingList().entrySet().iterator();
		Map.Entry entry;
		do{
			if(!iterator.hasNext()){
				return false;
			}
			entry = (Map.Entry)iterator.next();
		}while(!Tools.areItemStacksEqual(new ItemStack(stack.getItem(), stack.getMetadata()), (ItemStack)entry.getKey()));
		return true;
	}
}