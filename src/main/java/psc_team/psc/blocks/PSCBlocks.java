package psc_team.psc.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author The_Fireplace
 */
public class PSCBlocks {
	public static Block dehydrator = new BlockDehydrator();
	public static Block fertile_sand = new BlockFertileSand();

	//Register Blocks
	public static void createBlocks()
	{
		register(dehydrator);
		register(fertile_sand);
	}

	/**
	 * Registers a block to the gameregistry
	 * @param i
	 * 		The block being registered
	 */
	static void register(Block i){
		GameRegistry.registerBlock(i, i.getUnlocalizedName().substring(5));
	}
}
