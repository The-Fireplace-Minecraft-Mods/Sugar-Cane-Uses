package the_fireplace.sugarcaneuses.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * @author The_Fireplace
 */
public class RecipeHandler {
	//Put ItemStacks to be used in recipes here. An ItemStack with Sugar Cane is below as an example.
	static ItemStack sugarCaneStack = new ItemStack(Items.reeds);

	/**
	 * Register recipes here. The first line will be a commented out example.
	 */
	public static void registerRecipes(){
		//addRecipe(sugarCaneStack, "s", "g", "s", 's', sugarStack, 'g', glueStack);

	}

	private void addRecipe(ItemStack output, Object... inputs){
		GameRegistry.addRecipe(new ShapedOreRecipe(output, inputs));
	}
}
