package lotto.domain.enum

enum class Priority(val matchCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun getPrice(matchCount: Int): Int =
            values().find { priority -> priority.matchCount == matchCount }?.price ?: MISS.price

        fun find(matchCount: Int): Priority =
            normalPriorities().find { priority -> priority.matchCount == matchCount } ?: MISS

        private fun normalPriorities(): List<Priority> = values().filter { it != SECOND }
    }
}
