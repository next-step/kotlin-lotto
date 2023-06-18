package lotto.domain

import lotto.domain.lottery.LotteryTicket
import lotto.domain.lottery.WinnerLottery
import java.math.BigDecimal

object ProfitAnalyzer {
    fun getProfitRate(prizeStatics: PrizeStatics, purchaseAmount: Money): BigDecimal {
        return prizeStatics.getPrizeMoneyTotal() / purchaseAmount
    }

    fun getStaticsOnPrizeMoney(lotteryTicket: LotteryTicket, winnerLottery: WinnerLottery): PrizeStatics {
        val winnerPrizeMap = lotteryTicket.getWinnerPrizeMap(winnerLottery)
        return PrizeStatics(winnerPrizeMap)
    }
}
