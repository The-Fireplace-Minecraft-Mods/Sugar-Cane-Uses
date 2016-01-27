package psc_team.psc.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/*
 * @author SirBlobman
 */
public class SCUItems 
{
	//Register the Creative Tab named itemGroup.PSC
	public static final CreativeTabs SugarCaneUses = new CreativeTabs("PSC")
	{
		//Overrides default method, changes the icon for the creative tab -- SirBlobman
		@Override
		public Item getTabIconItem() 
		{
			return Items.reeds;
		}
	};
	
	//Item Objects
	public static Item reinforcedSugarCane = new BasicItem("reinforced_sugar_cane");
	
	//Register Items
	public static void createItems()
	{
		register(reinforcedSugarCane);
	}

	/**
	 * Registers an item to the gameregistry
	 * @param i
	 * 		The item being registered
	 */
	static void register(Item i){
		GameRegistry.registerItem(i, i.getUnlocalizedName().substring(5));
	}
}
