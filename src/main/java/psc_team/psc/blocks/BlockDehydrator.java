package psc_team.psc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import psc_team.psc.PSC;
import psc_team.psc.entity.tile.TileEntityDehydrator;
import psc_team.psc.items.SCUItems;
import psc_team.psc.tools.Tools;

/**
 * @author The_Fireplace
 */
public class BlockDehydrator extends BlockContainer {
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public BlockDehydrator() {
		super(Material.iron);
		setUnlocalizedName("dehydrator");
		setCreativeTab(PSC.PSC);
		setHardness(5.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 1);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state){
		super.onBlockAdded(world, pos, state);
		setDefaultDirection(world, pos, state);
	}

	private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state){
		if(!worldIn.isRemote){
			Block block = worldIn.getBlockState(pos.north()).getBlock();
			Block block1 = worldIn.getBlockState(pos.south()).getBlock();
			Block block2 = worldIn.getBlockState(pos.west()).getBlock();
			Block block3 = worldIn.getBlockState(pos.east()).getBlock();
			EnumFacing enumfacing = state.getValue(FACING);

			if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
				enumfacing = EnumFacing.SOUTH;
			else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
				enumfacing = EnumFacing.NORTH;
			else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
				enumfacing = EnumFacing.EAST;
			else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
				enumfacing = EnumFacing.WEST;

			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		}
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
			return true;
		else if(!playerIn.isSneaking()){
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityDehydrator)
			{
				FMLNetworkHandler.openGui(playerIn, PSC.MODID, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			return true;
		}else
			return false;
	}

	@Override
	protected BlockState createBlockState(){
		return new BlockState(this, FACING);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y)
			enumfacing = EnumFacing.NORTH;

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}
	@Override
	public int getMetaFromState(IBlockState state){
		return state.getValue(FACING).getIndex();
	}
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
		TileEntityDehydrator tile = (TileEntityDehydrator)worldIn.getTileEntity(pos);
		int f = tile.getStoredFuel();
		int fstacks = 0;
		while(f>64){
			fstacks++;
			f -= 64;
		}
		while(fstacks > 0){
			Tools.spawnItemAtPos(new ItemStack(SCUItems.fuelBar, 64), worldIn, pos);
			fstacks--;
		}
		if(f > 0)
			Tools.spawnItemAtPos(new ItemStack(SCUItems.fuelBar, f), worldIn, pos);
		super.breakBlock(worldIn, pos, state);
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta){
		return new TileEntityDehydrator();
	}
}
