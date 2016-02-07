package psc_team.psc.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import psc_team.psc.api.DehydratorAPI;
import psc_team.psc.blocks.PSCBlocks;
import psc_team.psc.items.PSCItems;

/**
 * @author The_Fireplace
 * @author SirBlobman
 * @author MCDeathslimbs
 */
public class RecipeHandler {
	//Put ItemStacks to be used in recipes here. An ItemStack with Sugar Cane is below as an example.
	static ItemStack sugarCaneStack = new ItemStack(Items.reeds);
	static ItemStack reinforcedSugarStack = new ItemStack(PSCItems.reinforcedSugarCane);
	static ItemStack sugarStack = new ItemStack(Items.sugar);
	static ItemStack glueStack = new ItemStack(PSCItems.glue);
	static ItemStack slimeStack = new ItemStack(Items.slime_ball);
	static ItemStack saplingStack = new ItemStack(Blocks.sapling, 1, OreDictionary.WILDCARD_VALUE);
	static ItemStack deadBushStack = new ItemStack(Blocks.deadbush);
	static ItemStack fertileSandStack = new ItemStack(PSCBlocks.fertile_sand);
	static ItemStack sandStack = new ItemStack(Blocks.sand);
	static ItemStack bonemealStack = new ItemStack(Items.dye,1,15);

	/**
	 * Register recipes here. The first line will be a <b>commented out</b> example.
	 */
	public static void registerRecipes(){
		//addRecipe(sugarCaneStack, "s", "g", "s", 's', sugarStack, 'g', glueStack);
		DehydratorAPI.addDehydratorRecipe(saplingStack, deadBushStack);
		DehydratorAPI.addDehydratorRecipe(slimeStack, glueStack);
		addRecipe(fertileSandStack, "sss", "sbs", "sss", 's', sandStack, 'b', bonemealStack);
	}

	private static void addRecipe(ItemStack output, Object... inputs){
		GameRegistry.addRecipe(new ShapedOreRecipe(output, inputs));
	}
}
