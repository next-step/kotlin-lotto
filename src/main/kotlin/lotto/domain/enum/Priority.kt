package lotto.domain.enum

enum class Priority(val matchCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND_BONUS(5, 30_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun getPrice(matchCount: Int): Int =
            values().find { priority -> priority.matchCount == matchCount }?.price ?: 0
    }
}
