package psc_team.psc.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import psc_team.psc.PSC;
import psc_team.psc.items.BasicItem;

/**
 * @author MCDeathslimbs
 */
public class ReinforcedPickaxe extends ItemPickaxe{
    public static Item ReinforcedPickaxe;
    public static Item.ToolMaterial reinforcedCane = EnumHelper.addToolMaterial("reinforcedCane",3, 300, 7.0F, 2.5F, 22);
    protected ReinforcedPickaxe(ToolMaterial material) {

        super(material);
        ReinforcedPickaxe = new ReinforcedPickaxe(reinforcedCane).setUnlocalizedName("ReinforcedPickaxe").setCreativeTab(PSC.PSC);
        GameRegistry.registerItem(ReinforcedPickaxe, "ReinforcedPickaxe");
    }

}
