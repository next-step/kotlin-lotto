package lotto.prize

class SimpleMatchCondition(
    override val matchCount: Int,
) : MatchCondition {
    override fun match(matchCount: Int, bonusMatch: Boolean): Boolean {
        return this.matchCount == matchCount
    }
}
