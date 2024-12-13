package com.example.slktap.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.slktap.data.repository.InMemoryShopListRepository
import com.example.slktap.domain.ShopItem
import com.example.slktap.domain.GetShopListUseCase
import com.example.slktap.domain.EditShopItemUseCase
import com.example.slktap.domain.DeleteShopItemUseCase

class MainViewModel : ViewModel() {

    private val repository = InMemoryShopListRepository
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    // Метод для получения списка товаров
    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    // Метод для добавления нового товара в список
    fun addShopItem(shopItem: ShopItem): Boolean {
        val currentList = shopList.value ?: emptyList()
        val updatedList = currentList + shopItem
        shopList.value = updatedList
        return true // Возвращаем true, так как добавление прошло успешно
    }
}
