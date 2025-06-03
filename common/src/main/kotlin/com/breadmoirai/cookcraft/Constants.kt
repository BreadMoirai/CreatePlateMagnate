package com.breadmoirai.cookcraft

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Constants {
    const val MOD_ID = "cookcraft"
    const val MOD_NAME = "CookCraft"
    @JvmStatic // needed so Mixins can access
    val LOG: Logger = LoggerFactory.getLogger(MOD_NAME)
}