package com.example.slktap.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.slktap.R
import com.example.slktap.domain.ShopItem

class AddShopItemActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shop_item)

        val editTextName = findViewById<EditText>(R.id.editTextShopItemName)
        val editTextCount = findViewById<EditText>(R.id.editTextShopItemCount)
        val buttonAddShopItem = findViewById<Button>(R.id.buttonAddShopItem)

        buttonAddShopItem.setOnClickListener {
            handleAddShopItem(editTextName, editTextCount)
        }
    }

    private fun handleAddShopItem(editTextName: EditText, editTextCount: EditText) {
        val name = editTextName.text.toString().trim()
        val countText = editTextCount.text.toString().trim()

        // Проверка на пустые поля
        if (name.isEmpty() || countText.isEmpty()) {
            Toast.makeText(this, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            return
        }

        val count = countText.toIntOrNull()
        if (count == null || count <= 0) {
            Toast.makeText(this, "Введите корректное количество!", Toast.LENGTH_SHORT).show()
            return
        }

        // Создаем новый товар
        val newShopItem = ShopItem(id = 0, name = name, count = count, enabled = true)

        // Добавляем товар через ViewModel
        val isAdded = viewModel.addShopItem(newShopItem)

        // Проверяем результат добавления
        if (isAdded) {
            Toast.makeText(this, "Товар добавлен: $name, количество: $count", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Не удалось добавить товар", Toast.LENGTH_SHORT).show()
        }

        // Завершаем активность
        finish()
    }
}
