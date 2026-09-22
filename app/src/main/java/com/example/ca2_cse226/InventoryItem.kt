package com.example.ca2_cse226

data class InventoryItem(
    val id: Int,
    val name: String,
    val stockCount: Int,
    val lowStockThreshold: Int
) {
    val isLowStock: Boolean
        get() = stockCount < lowStockThreshold
}
