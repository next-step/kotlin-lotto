package lotto.domain

import java.math.BigDecimal

object ProfitAnalyzer {
    fun getProfitRate(prizeStatics: PrizeStatics, purchaseAmount: Money): BigDecimal {
        return prizeStatics.getPrizeMoneyTotal() / purchaseAmount
    }

    fun getStaticsOnPrizeMoney(lotteryTicket: LotteryTicket, winnerLottery: Lottery): PrizeStatics {
        val countPerWinnerPrize =
            lotteryTicket.getMatchingCountMap(winnerLottery)
                .mapKeys { WinnerPrize.getWinnerPrize(it.key) }
        return PrizeStatics(countPerWinnerPrize)
    }
}
