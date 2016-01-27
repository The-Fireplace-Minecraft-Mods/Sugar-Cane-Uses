package psc_team.psc.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/*
 * @author SirBlobman
 */
public class SCUItems 
{
	//Item Objects
	public static Item reinforcedSugarCane = new BasicItem("reinforced_sugar_cane");
	public static Item sugarCaneStick = new BasicItem("sugar_cane_stick");
	public static Item fuelBar = new BasicItem("fuel_bar");
	
	//Register Items
	public static void createItems()
	{
		register(reinforcedSugarCane);
		register(sugarCaneStick);
		register(fuelBar);
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
