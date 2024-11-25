package lotto.domain.rank

interface RankCalculateStrategy {
    fun support(matchCount: Int, isBonusMatched: Boolean): Boolean
    fun calculate(matchCount: Int, isBonusMatched: Boolean): Rank
}

class DefaultRankCalculateStrategy : RankCalculateStrategy {
    override fun support(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return !(matchCount == 5 && isBonusMatched)
    }

    override fun calculate(matchCount: Int, isBonusMatched: Boolean): Rank {
        return Rank.entries.firstOrNull { it.matchCount == matchCount } ?: Rank.NONE
    }
}

class SecondRankCalculateStrategy : RankCalculateStrategy {
    override fun support(matchCount: Int, isBonusMatched: Boolean): Boolean {
        return matchCount == 5 && isBonusMatched
    }

    override fun calculate(matchCount: Int, isBonusMatched: Boolean): Rank {
        return Rank.SECOND
    }
}
