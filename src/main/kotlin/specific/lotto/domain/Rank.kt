package specific.lotto.domain

enum class Rank(
    val isWin: Boolean,
    val sameNumbersCount: Int,
    val bonusNumberCondition: BonusNumberCondition,
    val prize: Long,
) {
    FIRST(true, 6, BonusNumberCondition.IRRELEVANCE, 2000000000L),
    SECOND(true, 5, BonusNumberCondition.MATCH, 30000000L),
    THIRD(true, 5, BonusNumberCondition.MISMATCH, 1500000L),
    FOURTH(true, 4, BonusNumberCondition.IRRELEVANCE, 50000L),
    FIFTH(true, 3, BonusNumberCondition.IRRELEVANCE, 5000L),
    NO_WIN_TWO_MATCH(false, 2, BonusNumberCondition.IRRELEVANCE, 0L),
    NO_WIN_ONE_MATCH(false, 1, BonusNumberCondition.IRRELEVANCE, 0L),
    NO_WIN_ZERO_MATCH(false, 0, BonusNumberCondition.IRRELEVANCE, 0L);

    fun checkCondition(sameNumbersCount: Int, hasBonusNumber: Boolean): Boolean =
        sameNumbersCount == this.sameNumbersCount && bonusNumberCondition.checkCondition(hasBonusNumber)

    companion object {
        fun decideRank(sameNumbersCount: Int, hasBonusNumber: Boolean): Rank {
            return Rank.values().firstOrNull { it.checkCondition(sameNumbersCount, hasBonusNumber) }
                ?:throw IllegalArgumentException("impossible case")
        }
    }
}

enum class BonusNumberCondition(val checkCondition: (Boolean) -> Boolean) {
    MATCH({ isBonusMatch -> isBonusMatch }),
    MISMATCH({ isBonusMatch -> !isBonusMatch }),
    IRRELEVANCE({ true });
}
