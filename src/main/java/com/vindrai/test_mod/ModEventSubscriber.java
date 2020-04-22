package com.vindrai.test_mod;

import com.vindrai.test_mod.init.ModBlocks;
import com.vindrai.test_mod.init.ModItemGroups;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EventBusSubscriber(modid = TestMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    private static final Logger LOGGER = LogManager.getLogger(TestMod.MODID + " Mod Event Subscriber");

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event){

        final IForgeRegistry<Item> registry = event.getRegistry();

        event.getRegistry().registerAll(setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "idiot_baton"));

        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)
                .forEach(block -> {
                    final Item.Properties properties = new Item.Properties().group(ModItemGroups.MOD_BLOCK_GROUP);
                    final BlockItem blockItem = new BlockItem(block, properties);
                    blockItem.setRegistryName(block.getRegistryName());
                    LOGGER.debug(block.getRegistryName());
                    registry.register(blockItem);
                });
        LOGGER.debug("Registered BlockItems");
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(TestMod.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }
}
