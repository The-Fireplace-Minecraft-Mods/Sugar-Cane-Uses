package psc_team.psc.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import psc_team.psc.PSC;
import psc_team.psc.items.tools.ReinforcedPickaxe;

/*
 * @author SirBlobman
 * @author The_Fireplace
 * @author MCDeathslimbs
 */
public class PSCItems
{
	//Materials
	public static Item.ToolMaterial reinforcedCane = EnumHelper.addToolMaterial("reinforcedCane", 3, 300, 7.0F, 2.5F, 22);

	//Item Objects
	//Keep unlocalized names lowercase with underscores instead of spaces. It makes it easy to remember them when making localizations, textures, etc. when we have one way of doing it and not multiple.
	public static Item reinforcedSugarCane = new BasicItem("reinforced_sugar_cane");
	public static Item sugarCaneStick = new BasicItem("sugar_cane_stick");
	public static Item fuelBar = new BasicItem("fuel_bar");
	public static Item depletedFuelBar = new BasicItem("depleted_fuel_bar");
	public static Item glue = new BasicItem("glue");
	public static Item brownSugar = new BasicItem("brown_sugar");
	public static Item reinforcedPickaxe = new ReinforcedPickaxe(reinforcedCane).setUnlocalizedName("reinforced_pickaxe").setCreativeTab(PSC.PSC);

	//Register Items
	public static void createItems()
	{
		register(reinforcedSugarCane);
		register(sugarCaneStick);
		register(fuelBar);
		register(depletedFuelBar);
		register(glue);
		register(brownSugar);
		register(reinforcedPickaxe);
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
