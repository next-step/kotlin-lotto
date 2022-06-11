package lotto

enum class LottoPrize(val matchCount: Int, val reward: Int) {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    FIFTH_PLACE(2, 0),
    SIXTH_PLACE(1, 0),
    NO_PLACE(0, 0);

    companion object {
        fun of(matchCount: Int): LottoPrize {
            return values().find { it.matchCount == matchCount } ?: NO_PLACE
        }
    }
}
