package com.vindrai.test_mod.block;

import com.vindrai.test_mod.TestMod;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhaseBlock extends Block {

    public static final BooleanProperty PHASED = BlockStateProperties.OPEN;
    private static final Logger LOGGER = LogManager.getLogger(TestMod.MODID + "PhaseBlock");

    public PhaseBlock(final Block.Properties properties){
        super(properties);
        // Set the default values for our blockstate properties
        this.setDefaultState(this.getDefaultState().with(PHASED,Boolean.valueOf(false)));

    }

    @Override
    protected void fillStateContainer(final StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(PHASED);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState();
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, final World worldIn, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            if (state.get(PHASED)) {
                state = state.with(PHASED, Boolean.valueOf(false));
                worldIn.setBlockState(pos, state, 10);
                LOGGER.debug(state.get(PHASED));
            } else {
                state = state.with(PHASED, Boolean.valueOf(true));
                worldIn.setBlockState(pos, state, 10);
                LOGGER.debug(state.get(PHASED));
            }
        }
        return ActionResultType.SUCCESS;
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    public static Material PhaseBlockMaterial = new Material(MaterialColor.BLACK,false,false,false,true,false,false,true, PushReaction.NORMAL);
}
