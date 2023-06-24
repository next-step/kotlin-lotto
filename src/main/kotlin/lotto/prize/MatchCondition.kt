package lotto.prize

sealed interface MatchCondition {
    val matchCount: Int
    fun match(matchCount: Int, bonusMatch: Boolean): Boolean
}
