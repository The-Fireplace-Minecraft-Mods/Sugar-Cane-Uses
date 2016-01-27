package psc_team.psc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import psc_team.psc.PSC;

/**
 * @author The_Fireplace
 */
public class BlockDehydrator extends Block {
	public BlockDehydrator() {
		super(Material.iron);
		setUnlocalizedName("dehydrator");
		setCreativeTab(PSC.PSC);
		setHardness(5.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 1);
	}

	/**
	 * Called throughout the code as a replacement for block instanceof BlockContainer
	 * Moving this to the Block base class allows for mods that wish to extend vanilla
	 * blocks, and also want to have a tile entity on that block, may.
	 * <p/>
	 * Return true from this function to specify this block has a tile entity.
	 *
	 * @param state State of the current block
	 * @return True if block has a tile entity, false otherwise
	 */
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return super.hasTileEntity(state);
	}

	/**
	 * Called throughout the code as a replacement for ITileEntityProvider.createNewTileEntity
	 * Return the same thing you would from that function.
	 * This will fall back to ITileEntityProvider.createNewTileEntity(World) if this block is a ITileEntityProvider
	 *
	 * @param world
	 * @param state
	 * @return A instance of a class extending TileEntity
	 */
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return super.createTileEntity(world, state);
	}
}
