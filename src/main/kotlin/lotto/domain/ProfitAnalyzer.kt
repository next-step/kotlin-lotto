package lotto.domain

import java.math.BigDecimal

object ProfitAnalyzer {
    fun getProfitRate(prizeStatics: PrizeStatics, purchaseAmount: Money): BigDecimal {
        return prizeStatics.getPrizeMoneyTotal() / purchaseAmount
    }

    fun getStaticsOnPrizeMoney(lotteryTicket: LotteryTicket, winnerLottery: Lottery): PrizeStatics {
        val countPerWinnerPrize = lotteryTicket.groupingBy { getWinnerPrize(it, winnerLottery) }.eachCount()
        return PrizeStatics(countPerWinnerPrize)
    }

    private fun getWinnerPrize(lottery1: Lottery, lottery2: Lottery): WinnerPrize {
        val commonNumbers = lottery1 intersectNumbers lottery2
        return WinnerPrize.getWinnerPrize(commonNumbers.size)
    }
}
