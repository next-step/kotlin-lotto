package domain

enum class LottoWinningType(
    val priceMoney: Int,
    private val matcher: (matchCount: Int, hasBonusBall: Boolean) -> Boolean,
) {
    FIRST(2000000000, { matchCount, _ -> matchCount == 6 }),
    SECOND(30000000, { matchCount, hasBonusBall -> matchCount == 5 && hasBonusBall }),
    THIRD(1500000, { matchCount, _ -> matchCount == 5 }),
    FOURTH(50000, { matchCount, _ -> matchCount == 4 }),
    FIFTH(5000, { matchCount, _ -> matchCount == 3 }),
    NONE(0, { _, _ -> true }),
    ;

    companion object {
        fun from(
            matchingCount: Int,
            hasBonusBall: Boolean,
        ): LottoWinningType {
            return entries.find { it.matcher(matchingCount, hasBonusBall) } ?: NONE
        }
    }
}
