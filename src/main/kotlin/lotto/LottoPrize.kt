package lotto

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int) {
    FOURTH_PLACE(3, 5_000),
    THIRD_PLACE(4, 50_000),
    SECOND_PLACE(5, 1_500_000),
    FIRST_PLACE(6, 2_000_000_000),
    NOTHING(0, 0);

    companion object {
        fun getPrize(matchingNumbers: Int): Int {
            return values().firstOrNull { it.matchCount == matchingNumbers }?.prizeMoney ?: 0
        }
    }

}
