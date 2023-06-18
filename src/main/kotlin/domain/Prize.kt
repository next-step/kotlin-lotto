package domain

enum class Prize(
    val matches: Int,
    val prizeMoney: Int,
    val prizeMessage: String
) {
    FOURTH_PLACE(3, 5_000, "3개 일치 (5000원)"),
    THIRD_PLACE(4, 50_000, "4개 일치 (50000원)"),
    SECOND_PLACE(5, 1_500_000, "5개 일치 (1500000원)"),
    FIRST_PLACE(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    ;
    companion object {
        fun getPrizeForMatches(matches: Int) = values().firstOrNull { it.matches == matches }?.prizeMoney ?: 0
    }
}
