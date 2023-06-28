package lotto.prize

class BonusMatchCondition(
    override val matchCount: Int,
    override val priority: Int,
) : MatchCondition {
    override fun match(matchCount: Int, bonusMatch: Boolean): Boolean {
        return this.matchCount == matchCount && bonusMatch
    }
}
