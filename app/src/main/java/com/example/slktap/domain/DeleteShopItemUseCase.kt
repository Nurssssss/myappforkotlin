package com.example.slktap.domain

class DeleteShopItemUseCase (private val shopListRepository: ShopListRepository){

    fun deleteShopItem(shopItem: ShopItem){
       return shopListRepository.deleteShopItem(shopItem)

    }


}