package the_fireplace.sugarcaneuses.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * int Author = The_Fireplace + SirBlobman;
 */
public class RecipeHandler {
	//Put ItemStacks to be used in recipes here. An ItemStack with Sugar Cane is below as an example.
	static ItemStack sugarCaneStack = new ItemStack(Items.reeds);
	static ItemStack sugarStack = new ItemStack(Items.sugar);
	static ItemStack glueStack = new ItemStack(Items.slime_ball);

	/**
	 * Register recipes here. The first line will be a commented out example.
	 */
	public static void registerRecipes(){
		addRecipe(sugarCaneStack, "s", "g", "s", 's', sugarStack, 'g', glueStack);

	}

	//Changed to static to fix error -- SirBlobman
	private static void addRecipe(ItemStack output, Object... inputs){
		GameRegistry.addRecipe(new ShapedOreRecipe(output, inputs));
	}
}
