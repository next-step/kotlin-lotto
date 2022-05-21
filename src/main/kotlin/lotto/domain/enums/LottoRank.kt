package lotto.domain.enums

enum class LottoRank(val matchingCount: Int, val rewardPrice: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, 0);

    fun sumOfPrice(numberOfLotto: Int): Long {
        return rewardPrice * numberOfLotto
    }

    companion object {
        fun of(matchingCount: Int, isMatchBonusNumber: Boolean): LottoRank {
            return when (matchingCount) {
                FIRST.matchingCount -> FIRST
                SECOND.matchingCount -> if (isMatchBonusNumber) SECOND else THIRD
                FOURTH.matchingCount -> FOURTH
                FIFTH.matchingCount -> FIFTH
                else -> NONE
            }
        }
    }
}
