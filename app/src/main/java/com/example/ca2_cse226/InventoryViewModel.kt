package com.example.ca2_cse226

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InventoryViewModel : ViewModel() {

    private val _items = MutableStateFlow(
        listOf(
            InventoryItem(1, "Laptop", 10, 3),
            InventoryItem(2, "Wireless Mouse", 2, 5),
            InventoryItem(3, "Keyboard", 15, 4),
            InventoryItem(4, "USB-C Cable", 1, 8),
            InventoryItem(5, "Monitor", 5, 2)
        )
    )
    val items: StateFlow<List<InventoryItem>> = _items.asStateFlow()

    fun incrementStock(id: Int) {
        _items.update { currentList ->
            currentList.map { item ->
                if (item.id == id) {
                    item.copy(stockCount = item.stockCount + 1)
                } else {
                    item
                }
            }
        }
    }

    fun decrementStock(id: Int) {
        _items.update { currentList ->
            currentList.map { item ->
                if ((item.id == id) && (item.stockCount > 0)) {
                    item.copy(stockCount = item.stockCount - 1)
                } else {
                    item
                }
            }
        }
    }
}
