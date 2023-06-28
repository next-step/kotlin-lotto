package lotto.prize

sealed interface MatchCondition {
    val matchCount: Int
    val priority: Int
    fun match(matchCount: Int, bonusMatch: Boolean): Boolean
}
