package com.example.madlevel4task1.model;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "amount")
    var amount: Int
)
