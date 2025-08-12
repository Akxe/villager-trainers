package com.akxe.villager_trainers.fabric;

import com.akxe.villager_trainers.IModLoader;
import com.akxe.villager_trainers.ModCommon;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public final class FabricCommon implements ModInitializer {
    class ModLoader implements IModLoader {
        public boolean isLoaded(String modId) {
            return FabricLoader.getInstance().isModLoaded(modId);
        }
    }

    @Override
    public void onInitialize() {
        ModCommon.init(new ModLoader());
        // com.akxe.villager_trainers.example.ExampleMod.init(); // uncomment for example
    }
}
