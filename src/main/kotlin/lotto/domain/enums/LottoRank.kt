package lotto.domain.enums

interface RankMatchable {
    fun isMatch(matchingCount: Int, isMatchBonusNumber: Boolean): Boolean
}

enum class LottoRank(val matchingCount: Int, val rewardPrice: Long) : RankMatchable {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000) {
        override fun isMatch(matchingCount: Int, isMatchBonusNumber: Boolean): Boolean {
            return this.matchingCount == matchingCount && isMatchBonusNumber
        }
    },
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, 0);

    fun sumOfPrice(numberOfLotto: Int): Long {
        return rewardPrice * numberOfLotto
    }

    override fun isMatch(matchingCount: Int, isMatchBonusNumber: Boolean): Boolean {
        return this.matchingCount == matchingCount
    }

    companion object {
        fun of(matchingCount: Int, isMatchBonusNumber: Boolean): LottoRank {
            return values().find { it.isMatch(matchingCount, isMatchBonusNumber) } ?: NONE
        }
    }
}
