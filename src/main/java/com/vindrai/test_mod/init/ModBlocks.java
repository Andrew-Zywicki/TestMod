package com.vindrai.test_mod.init;

import com.vindrai.test_mod.TestMod;
import com.vindrai.test_mod.block.IdiotWoodBlock;
import com.vindrai.test_mod.block.PhaseBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestMod.MODID);

    public static final RegistryObject<Block> PHASE_BLOCK = BLOCKS.register(
            "phase_block", () -> new PhaseBlock(Block.Properties.create(PhaseBlock.PhaseBlockMaterial).hardnessAndResistance(3.0F, 3.0F)));

    //blocks
    public static final RegistryObject<Block> IDIOT_WOOD = BLOCKS.register(
            "idiot_wood", () -> new IdiotWoodBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));


}
