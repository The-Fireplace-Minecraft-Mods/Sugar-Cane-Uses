package psc_team.psc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import psc_team.psc.PSC;

/**
 * Author MCDeathslimbs
 */
public class BlockFertileSand extends Block
{
    public BlockFertileSand() {
        super(Material.sand);
        setUnlocalizedName("FertileSand");
        setCreativeTab(PSC.PSC);
        setHardness(2.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 1);

    }
}
