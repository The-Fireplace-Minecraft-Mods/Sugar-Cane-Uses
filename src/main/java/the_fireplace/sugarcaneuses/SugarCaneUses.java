package the_fireplace.sugarcaneuses;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import the_fireplace.sugarcaneuses.recipes.RecipeHandler;

/**
 * @author The_Fireplace
 */
@Mod(modid=SugarCaneUses.MODID, name=SugarCaneUses.MODNAME)
public class SugarCaneUses {
	public static final String MODID = "sugarcaneuses";
	public static final String MODNAME = "Sugar Cane Uses";
	public static String VERSION;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Register Items/Blocks/most everything else here
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		RecipeHandler.registerRecipes();
		if(event.getSide().isClient())
			registerItemRenders();
	}

	@SideOnly(Side.CLIENT)
	public void registerItemRenders(){

	}
}
