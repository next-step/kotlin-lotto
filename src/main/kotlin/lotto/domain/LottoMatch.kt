package lotto.domain

data class LottoMatch(
    val matchNumber: Int,
    val reward: Long,
    var matchCount: Long
)
