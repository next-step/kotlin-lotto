package lotto.prize

class SimpleMatchCondition(
    override val matchCount: Int,
) : MatchCondition {
    override val priority = Int.MAX_VALUE

    override fun match(matchCount: Int, bonusMatch: Boolean): Boolean {
        return this.matchCount == matchCount
    }
}
