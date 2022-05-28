package lotto.dto

import lotto.domain.LottoPrizePolicy
import lotto.domain.Money

data class WinningStatDto(val lottoPrizePolicy: LottoPrizePolicy, val totalWinningCount: Int) {
    val totalWinningPrize: Money = Money(lottoPrizePolicy.wonPrize.value * totalWinningCount)
}
