package psc_team.psc.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * @author The_Fireplace
 * @author SirBlobman
 */
public class RecipeHandler {
	//Put ItemStacks to be used in recipes here. An ItemStack with Sugar Cane is below as an example.
	static ItemStack sugarCaneStack = new ItemStack(Items.reeds);
	static ItemStack sugarStack = new ItemStack(Items.sugar);
	static ItemStack glueStack = new ItemStack(Items.slime_ball);
	static ItemStack saplingStack = new ItemStack(Blocks.sapling, 1, OreDictionary.WILDCARD_VALUE);
	static ItemStack deadBushStack = new ItemStack(Blocks.deadbush);

	/**
	 * Register recipes here. The first line will be a <b>commented out</b> example.
	 */
	public static void registerRecipes(){
		//addRecipe(sugarCaneStack, "s", "g", "s", 's', sugarStack, 'g', glueStack);
		DehydratorRecipes.instance().addDehydratorRecipe(saplingStack, deadBushStack, 1);
	}

	private static void addRecipe(ItemStack output, Object... inputs){
		GameRegistry.addRecipe(new ShapedOreRecipe(output, inputs));
	}
}
