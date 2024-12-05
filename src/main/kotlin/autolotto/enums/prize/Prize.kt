package autolotto.enums.prize

enum class Prize(val matchCount: Int, val prizeMoney: Int) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    BONUS(5, 30000000),
    SIX(6, 2000000000),
    ;

    open fun calculatePrize(count: Int): Int {
        return count * prizeMoney
    }

    companion object {
        fun fromMatchCount(
            matchCount: Int,
            hasBonus: Boolean,
        ): Prize? {
            return when {
                matchCount == 6 -> SIX
                matchCount == 5 && hasBonus -> BONUS // 5개 일치 + 보너스 번호
                matchCount == 5 -> FIVE
                matchCount == 4 -> FOUR
                matchCount == 3 -> THREE
                else -> null
            }
        }
    }
}
