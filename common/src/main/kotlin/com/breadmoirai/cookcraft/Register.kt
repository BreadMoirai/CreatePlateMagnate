package com.breadmoirai.cookcraft

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour

fun register(
    name: String,
    blockFactory: (BlockBehaviour.Properties) -> Block,
    blockProperties: BlockBehaviour.Properties,
    itemProperties: Item.Properties? = null,
): Block {
    val resource = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name)
    // Create a registry key for the block
    val blockKey: ResourceKey<Block> = ResourceKey.create(Registries.BLOCK, resource)
    // Create the block instance
    val block: Block = blockFactory(blockProperties)

    itemProperties?.let {
        val itemKey: ResourceKey<Item> =  ResourceKey.create(Registries.ITEM, resource)
        val blockItem = BlockItem(block, it)
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem)
    }
    return Registry.register(BuiltInRegistries.BLOCK, blockKey, block)
}

fun register(name: String, itemFactory: (Item.Properties) -> Item, itemProperties: Item.Properties): Item {
    val resource = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name)
    val itemKey: ResourceKey<Item> =  ResourceKey.create(Registries.ITEM, resource)
    val item = itemFactory(itemProperties)
    return Registry.register(BuiltInRegistries.ITEM, itemKey, item)
}