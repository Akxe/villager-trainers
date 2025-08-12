package com.akxe.villager_trainers.neoforge;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;

import com.akxe.villager_trainers.IModLoader;
import com.akxe.villager_trainers.ModCommon;

@Mod(ModCommon.MOD_ID)
public final class NeoForgeCommon {
    class ModLoader implements IModLoader {
        public boolean isLoaded(String modId) {
            return FMLLoader.getLoadingModList().getModFileById(modId) != null;
        }
    }

    public NeoForgeCommon(ModContainer container) {
        container.getEventBus().addListener(this::onCommonSetup);
    }

    void onCommonSetup(FMLCommonSetupEvent event) {
        ModCommon.init(new ModLoader());
        // com.akxe.villager_trainers.example.ExampleMod.init(); // uncomment for example
    }
}
