package com.akxe.villager_trainers.fabric.client;

import com.akxe.villager_trainers.client.ModClient;

import net.fabricmc.api.ClientModInitializer;

public final class FabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModClient.init();
    }
}
