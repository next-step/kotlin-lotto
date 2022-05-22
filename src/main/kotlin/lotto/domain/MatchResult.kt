package lotto.domain

data class MatchResult(
    val matchCount: Int,
    val price: Money,
    val winCount: Int,
)
