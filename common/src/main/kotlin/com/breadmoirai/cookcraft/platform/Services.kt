package com.breadmoirai.cookcraft.platform

import com.breadmoirai.cookcraft.Constants
import com.breadmoirai.cookcraft.platform.services.PlatformHelper
import java.util.ServiceLoader

object Services {
    val PLATFORM = load(PlatformHelper::class.java)

    @JvmStatic
    fun <T> load(clazz: Class<T>): T {
        val loadedService = ServiceLoader.load(clazz)
            .findFirst()
            .orElseThrow {
                IllegalStateException("Failed to load service for ${clazz.name}")
            }
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz)
        return loadedService
    }
}