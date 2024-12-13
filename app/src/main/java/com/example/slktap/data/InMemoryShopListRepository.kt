package com.example.slktap.data.repository

import com.example.slktap.domain.ShopItem
import com.example.slktap.domain.ShopListRepository

object InMemoryShopListRepository : ShopListRepository {
    private val shopItems = mutableListOf(
        ShopItem(1, "Item 1", 100, true),
        ShopItem(2, "Item 2", 50, false),
        ShopItem(3, "Item 3", 200, true)
    )

    override fun addShopItem(shopItem: ShopItem) {
        shopItems.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopItems.removeIf { it.id == shopItem.id }
    }

    override fun editShopItem(shopItem: ShopItem) {
        val index = shopItems.indexOfFirst { it.id == shopItem.id }
        if (index != -1) {
            shopItems[index] = shopItem
        }
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopItems.find { it.id == shopItemId }
            ?: throw NoSuchElementException("ShopItem with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopItems.toList()
    }
}
