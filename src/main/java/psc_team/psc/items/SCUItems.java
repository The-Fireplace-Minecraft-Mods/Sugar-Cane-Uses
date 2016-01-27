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
	public static Item reinforcedSugarCane;
	
	//Register Items
	public static void createItems()
	{
		//GameRegistry code: .registerItem(object = new Class(unlocalizedName), "item_name" -- SirBlobman
		GameRegistry.registerItem(reinforcedSugarCane = new BasicItem("reinforced_sugar_cane"), "reinforced_sugar_cane");
	}
}
