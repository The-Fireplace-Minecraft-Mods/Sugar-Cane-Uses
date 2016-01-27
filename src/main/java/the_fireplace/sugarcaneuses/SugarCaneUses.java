package the_fireplace.sugarcaneuses;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sirblobman.sugarcaneuses.items.SCUItems;
import the_fireplace.sugarcaneuses.recipes.RecipeHandler;

/**
 * @author The_Fireplace
 * @author SirBlobman
 */
@Mod(modid=SugarCaneUses.MODID, name=SugarCaneUses.MODNAME)
public class SugarCaneUses {
	public static final String MODID = "psc";
	public static final String MODNAME = "Project Sugar Cane";
	public static String VERSION;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Register Items/Blocks/most everything else here
		SCUItems.createItems();
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		RecipeHandler.registerRecipes();
		if(event.getSide().isClient())
			registerItemRenders();
	}

	@SideOnly(Side.CLIENT)
	public void registerItemRenders()
	{
		//Calls the registry to create Modeled Items.
		reg(SCUItems.reinforcedSugarCane);
	}
	@SideOnly(Side.CLIENT)
	public static void reg(Item item) 
	{
		//Code to register item model locations
		//Location = modid:item_unlocalized_name
		//Example = sugarcaneuses:sugar_cane
		//An Example Model was made for reinforced_sugar_cane
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
