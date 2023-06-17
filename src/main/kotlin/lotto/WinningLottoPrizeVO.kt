package lotto

import java.math.BigDecimal

class WinningLottoPrizeVO(
    val matchedCount: Int,
    val prizeAmount: BigDecimal,
    val winningLottoCount: Int,
)
