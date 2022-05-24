package lotto.dto

import lotto.domin.LottoWinningAmount

data class WinningStaticsResponseDto(
    val winningLottoList: Map<LottoWinningAmount, Int>,
    val profitRatio: Double,
)
