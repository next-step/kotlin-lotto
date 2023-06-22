package domain

enum class Prize(
    val matches: Int,
    val prizeMoney: Int,
    val prizeMessage: String,
) {
    FIFTH_PLACE(3, 5_000, "3개 일치 (5000원)"),
    FOURTH_PLACE(4, 50_000, "4개 일치 (50000원)"),
    THIRD_PLACE(5, 1_500_000, "5개 일치 (1500000원)"),
    SECOND_PLACE(5, 3_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    FIRST_PLACE(6, 2_000_000_000, "6개 일치 (2000000000원)"), ;

    companion object {
        fun getPrizeMoneyByCount(
            count: Int,
            containBonusBall: Boolean,
        ): Int {
            return when {
                count == FIRST_PLACE.matches -> FIRST_PLACE.prizeMoney
                count == SECOND_PLACE.matches && containBonusBall -> SECOND_PLACE.prizeMoney
                count == THIRD_PLACE.matches -> THIRD_PLACE.prizeMoney
                count == FOURTH_PLACE.matches -> FOURTH_PLACE.prizeMoney
                count == FIFTH_PLACE.matches -> FIFTH_PLACE.prizeMoney
                else -> 0
            }
        }
    }
}
