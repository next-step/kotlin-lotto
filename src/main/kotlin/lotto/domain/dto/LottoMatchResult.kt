package lotto.domain.dto

data class LottoMatchResult(
    val matchCount: Int,
    val isBonusMatch: Boolean = false
)