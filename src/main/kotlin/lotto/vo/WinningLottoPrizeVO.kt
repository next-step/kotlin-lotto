package lotto.vo

import java.math.BigDecimal

data class WinningLottoPrizeVO(
    val matchedCount: Int,
    val prizeAmount: BigDecimal,
    val winningLottoCount: Int,
    val bonusMatched: Boolean,
)
