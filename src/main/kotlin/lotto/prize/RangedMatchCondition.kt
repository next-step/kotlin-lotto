package lotto.prize

class RangedMatchCondition(
    upperBound: Int,
    override val priority: Int,
) : MatchCondition {
    override val matchCount: Int = upperBound

    override fun match(matchCount: Int, bonusMatch: Boolean): Boolean {
        return this.matchCount >= matchCount
    }
}
