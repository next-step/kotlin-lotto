package model

class Lotto {
    companion object {
        const val MAKE_NUMBER_COUNT = 6
        fun create(): List<Int> {
            return listOf(1, 2, 3, 4, 5, 6)
        }
    }
}
