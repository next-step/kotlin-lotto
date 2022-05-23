package lotto.domain

data class LottoMatchResult(
    val matchCount: Int,
    val price: Money,
    val winCount: Int,
)
