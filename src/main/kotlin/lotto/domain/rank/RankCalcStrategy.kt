package lotto.domain.rank

interface RankCalcStrategy {
    fun support(matchCount: Int, isBonusMatched: Boolean): Boolean
    fun calculate(matchCount: Int, isBonusMatched: Boolean): Rank
}

class DefaultRankCalcStrategy : RankCalcStrategy {
    override fun support(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return !(matchCount == 5 && isBonusMatched)
    }

    override fun calculate(matchCount: Int, isBonusMatched: Boolean): Rank {
        return Rank.entries.firstOrNull { it.matchCount == matchCount } ?: Rank.NONE
    }
}

class SecondRankCalcStrategy : RankCalcStrategy {
    override fun support(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == 5 && isBonusMatched
    }

    override fun calculate(matchCount: Int, isBonusMatched: Boolean): Rank {
        return Rank.SECOND
    }
}
