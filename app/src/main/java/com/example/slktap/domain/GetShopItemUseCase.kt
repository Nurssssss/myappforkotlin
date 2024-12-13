package com.example.slktap.domain

data class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemId: Int): ShopItem? {
        return shopListRepository.getShopItem(shopItemId)
    }
}

