package lotto.view.dto

data class LottoRankDto(
    val matchCount: Int,
    val containBonus: Boolean,
    val reward: Long,
    val winCount: Int,
)
