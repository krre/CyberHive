package org.cyberhive.utils

object Constants {
    val virtualWidth = 800f
    val virtualHeight = 480f
}

enum class File {
    SAVE
    LOAD
}

enum class Cell(val landscape: Int) {
    EMPTY : Cell(0)
    WATER : Cell(1)
    SAND : Cell(2)
    MOUNTAIN : Cell(3)
    FOREST : Cell(4)
    FIELD : Cell(5)
}


