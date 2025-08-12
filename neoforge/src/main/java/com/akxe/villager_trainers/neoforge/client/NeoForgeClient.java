package com.akxe.villager_trainers.neoforge.client;

import com.akxe.villager_trainers.ModCommon;
import com.akxe.villager_trainers.client.ModClient;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = ModCommon.MOD_ID, dist = Dist.CLIENT)
public class NeoForgeClient {
    public NeoForgeClient() {
        ModClient.init();
    }
}
