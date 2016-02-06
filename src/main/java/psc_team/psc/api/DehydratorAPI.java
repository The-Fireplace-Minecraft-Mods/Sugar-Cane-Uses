package psc_team.psc.api;

import net.minecraft.item.ItemStack;
import psc_team.psc.recipes.DehydratorRecipes;

/**
 * @author The_Fireplace
 */
public class DehydratorAPI {
	/**
	 * Adds a recipe to the Dehydrator
	 * @param isIn
	 * 		The itemstack of the input, containing the item and metadata
	 * @param isOut
	 * 		The itemstack of the output, containing the item and metadata
	 * @param resultCount
	 * 		The number of items to output per input
	 */
	public static void addDehydratorRecipe(ItemStack isIn, ItemStack isOut, int resultCount){
		DehydratorRecipes.instance().addDehydratorRecipe(isIn, isOut, resultCount);
	}
	/**
	 * Adds a recipe to the Dehydrator
	 * @param isIn
	 * 		The itemstack of the input, containing the item and metadata
	 * @param isOut
	 * 		The itemstack of the output, containing the item, stack size, and metadata
	 */
	public static void addDehydratorRecipe(ItemStack isIn, ItemStack isOut){
		DehydratorRecipes.instance().addDehydratorRecipe(isIn, isOut, isOut.stackSize);
	}
}
