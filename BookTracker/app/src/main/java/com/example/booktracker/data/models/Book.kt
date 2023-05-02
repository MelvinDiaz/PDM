package com.example.booktracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table", primaryKeys = ["title", "isbn"])
data class Book(
    val title: String,
    val authors: List<Author>,
    val publisher: Publisher,
    val publicationYear: String,
    val pageCount: Int,
    val subject: String,
    val summary: String,
    val isbn: String
) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0L
}