package lotto.model

enum class Rank(
    private val matchCount: Int,
    private val isRequireBonus: Boolean,
    private val prize: Int,
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 222222222),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    BOOM(2, false, 0), ;

    fun totalPrizeOf(count: Int): Int {
        return this.prize * count
    }

    companion object {
        fun matchCountToRank(matchCount: Int, bonus: Boolean): Rank {
            if (matchCount < 3) {
                return BOOM
            }
            if (matchCount == SECOND.matchCount) {
                return when (bonus == SECOND.isRequireBonus) {
                    true -> SECOND
                    false -> THIRD
                }
            }
            return requireNotNull(Rank.values().firstOrNull { (it.matchCount == matchCount) }) { "잘못된 숫자" }
        }
    }
}
