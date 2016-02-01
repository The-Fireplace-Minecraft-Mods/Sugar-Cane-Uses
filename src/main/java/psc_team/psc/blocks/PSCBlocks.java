package psc_team.psc.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author The_Fireplace
 */
public class PSCBlocks {
	public static Block dehydrator;

	public static void instantiateBlocks(){
		dehydrator = new BlockDehydrator();
	}

	//Register Blocks
	public static void createBlocks()
	{
		register(dehydrator);
	}

	/**
	 * Registers a block to the gameregistry
	 * @param i
	 * 		The block being registered
	 */
	static void register(Block i){
		GameRegistry.registerItem(Item.getItemFromBlock(i), i.getUnlocalizedName().substring(5));
	}
}
