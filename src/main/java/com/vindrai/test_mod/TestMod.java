package com.vindrai.test_mod;

import com.vindrai.test_mod.init.ModBlocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TestMod.MODID)
public final class TestMod {

    public static final String MODID = "test_mod";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public TestMod() {
        LOGGER.debug("Logging system test from Testmod");

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);

    }
}
