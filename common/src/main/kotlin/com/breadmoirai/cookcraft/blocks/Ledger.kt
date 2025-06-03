package com.breadmoirai.cookcraft.blocks

import com.breadmoirai.cookcraft.register
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

class Ledger(properties: Properties) : Block(properties) {
    companion object {
        private val blockProperties: Properties = Properties.of().forceSolidOn().noCollission().destroyTime(1.0F)
        private val itemProperties: Item.Properties = Item.Properties().stacksTo(1)
        init {
            register("ledger", ::Ledger, blockProperties, itemProperties)
        }
    }


}