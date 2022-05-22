package lotto

data class WinningStaticsResponseDto(
    val winningLottoList: Map<LottoWinningAmount, Int>,
    val profitRatio: Double,
)
