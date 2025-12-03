package domain.winning

enum class LottoWinningType(
    val priceMoney: Int,
    private val matcher: (matchCount: Int, bonusNumberMatched: Boolean) -> Boolean,
) {
    FIRST(2000000000, { matchCount, _ -> matchCount == 6 }),
    SECOND_WITH_BONUS(30000000, { matchCount, bonusMatched -> matchCount == 5 && bonusMatched }),
    SECOND(1500000, { matchCount, bonusMatched -> matchCount == 5 && !bonusMatched }),
    THIRD(50000, { matchCount, _ -> matchCount == 4 }),
    FOURTH(5000, { matchCount, _ -> matchCount == 3 }),
    NONE(0, { _, _ -> false }),
    ;

    companion object {
        fun of(
            matchCount: Int,
            bonusNumberMatched: Boolean,
        ): LottoWinningType = entries.firstOrNull { it.matcher(matchCount, bonusNumberMatched) } ?: NONE
    }
}
