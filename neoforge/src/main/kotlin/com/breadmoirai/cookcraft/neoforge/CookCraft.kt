package com.breadmoirai.cookcraft.neoforge

import com.breadmoirai.cookcraft.Constants
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod

@Mod(Constants.MOD_ID)
class CookCraft(eventBus: IEventBus, modContainer: ModContainer) {
    init {
        Constants.LOG.info("Hello NeoForge world from Kotlin!")
        CookCraft.init()
    }
}