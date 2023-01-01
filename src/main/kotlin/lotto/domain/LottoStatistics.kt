package lotto.domain

data class LottoStatistics(
    val rank: Map<WinningAmount, Int>
)
