package psc_team.psc.recipes;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import psc_team.psc.tools.Tools;

import java.util.Iterator;
import java.util.Map;

/**
 * @author The_Fireplace
 */
public class DehydratorRecipes {
	public static final DehydratorRecipes pfBase = new DehydratorRecipes();
	private final Map poppingList = Maps.newHashMap();
	public static DehydratorRecipes instance(){
		return pfBase;
	}
	/**
	 * Adds a recipe to the Dehydrator
	 * @param isIn
	 * 		The itemstack of the input, containing the item and metadata
	 * @param isOut
	 * 		The itemstack of the output, containing the item and metadata
	 * @param resultCount
	 * 		The number of items to output per input
	 */
	public void addDehydratorRecipe(ItemStack isIn, ItemStack isOut, int resultCount){
		poppingList.put(new ItemStack(isIn.getItem(), 1, isIn.getMetadata()), new ItemStack(isOut.getItem(), resultCount, isOut.getMetadata()));
	}
	/**
	 * Gets the result of dehydrating an item
	 * @param is
	 * 		The input
	 * @return
	 * 		The result of dehydrating the item
	 */
	public ItemStack getResult(ItemStack is){
		Iterator iterator = poppingList.entrySet().iterator();
		Map.Entry entry;
		do{
			if(!iterator.hasNext()){
				return null;
			}
			entry = (Map.Entry)iterator.next();
		}while(!Tools.areItemStacksEqual(new ItemStack(is.getItem(), 1, is.getMetadata()), (ItemStack)entry.getKey()));
		return (ItemStack)entry.getValue();
	}
	/**
	 * Gets how many items will be output
	 * @param is
	 * 		The <b>input</b> ItemStack in the pop furnace recipe
	 * @return
	 * 		The number of items output for that input
	 */
	public int getResultCount(ItemStack is){
		Iterator iterator = poppingList.entrySet().iterator();
		Map.Entry entry;
		do{
			if(!iterator.hasNext()){
				return 0;
			}
			entry = (Map.Entry)iterator.next();
		}while(!Tools.areItemStacksEqual(new ItemStack(is.getItem(), 1, is.getMetadata()), (ItemStack)entry.getKey()));
		return ((ItemStack) entry.getValue()).stackSize;
	}

	public Map getDehydratingList(){
		return poppingList;
	}

	public static boolean isFuel(ItemStack item){
		return TileEntityFurnace.getItemBurnTime(item) > 0;
	}
}
