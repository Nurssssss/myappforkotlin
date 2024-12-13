package com.example.slktap.domain

data class AddShopItemUseCase (private val shopListRepository: ShopListRepository){

    fun addShopItem(shopItem: ShopItem){
      return shopListRepository.addShopItem(shopItem)
    }
}
