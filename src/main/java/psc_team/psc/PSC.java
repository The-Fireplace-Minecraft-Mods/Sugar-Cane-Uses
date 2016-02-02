package psc_team.psc;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import psc_team.psc.blocks.PSCBlocks;
import psc_team.psc.entity.tile.TileEntityDehydrator;
import psc_team.psc.handlers.PSCGuiHandler;
import psc_team.psc.items.PSCItems;
import psc_team.psc.recipes.RecipeHandler;

/**
 * @author The_Fireplace
 * @author SirBlobman
 */
@Mod(modid= PSC.MODID, name= PSC.MODNAME)
public class PSC {
	public static final String MODID = "psc";
	public static final String MODNAME = "Project Sugar Cane";
	public static String VERSION;

	//Register the Creative Tab named itemGroup.PSC
	public static final CreativeTabs PSC = new CreativeTabs("PSC")
	{
		//Overrides default method, changes the icon for the creative tab -- SirBlobman
		@Override
		public Item getTabIconItem()
		{
			return Items.reeds;
		}
	};

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Register Items/Blocks/most everything else here
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new PSCGuiHandler());
		GameRegistry.registerTileEntity(TileEntityDehydrator.class, "dehydrator");
		PSCBlocks.instantiateBlocks();
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		PSCItems.createItems();
		PSCBlocks.createBlocks();
		RecipeHandler.registerRecipes();
		if(event.getSide().isClient())
			registerItemRenders();
	}

	@SideOnly(Side.CLIENT)
	public void registerItemRenders()
	{
		//Calls the registry to create Modeled Items.
		reg(PSCItems.reinforcedSugarCane);
		reg(PSCItems.fuelBar);
		reg(PSCItems.depletedFuelBar);
		reg(PSCItems.sugarCaneStick);
		reg(PSCBlocks.dehydrator);
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
	@SideOnly(Side.CLIENT)
	public static void reg(Block block)
	{
		//Code to register item model locations
		//Location = modid:item_unlocalized_name
		//Example = sugarcaneuses:sugar_cane
		//An Example Model was made for reinforced_sugar_cane
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}
