package com.akxe.villager_trainers.fabric;

import net.fabricmc.api.ModInitializer;
import com.akxe.villager_trainers.VillagerTrainersMod;

public final class VillagerTrainersModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        VillagerTrainersMod.init();
    }
}
