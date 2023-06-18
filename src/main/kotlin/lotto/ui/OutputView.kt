package lotto.ui

import lotto.domain.PrizeStatics
import lotto.domain.WinnerPrize
import lotto.domain.lottery.LotteryTicket
import lotto.domain.result.LotteryPurchaseResults
import lotto.domain.result.PurchaseType
import java.math.BigDecimal

object OutputView {
    fun showLotteryTicket(lotteryTicket: LotteryTicket) {
        println("${lotteryTicket.getNumbersCount()}개를 구매했습니다.")

        lotteryTicket.lotteries.forEach(::println)
    }

    fun showStatics(statics: PrizeStatics) {
        println("당첨 통계")
        println("---------")
        WinnerPrize.values().forEach {
            val cnt = statics[it] ?: 0
            println("${getMatchMessage(it)} (${it.prizeMoney.value}원) - ${cnt}개")
        }
    }

    private fun getMatchMessage(prize: WinnerPrize): String = when (prize) {
        WinnerPrize.SECOND_PRIZE -> "${prize.matchCount}개 일치, 보너스볼 일치"
        else -> "${prize.matchCount}개 일치"
    }

    fun showProfitRate(profitRate: BigDecimal) {
        println("총 수익률은 ${profitRate}입니다.")
    }

    fun showLotteryTicketInfo(lotteryPurchaseResults: LotteryPurchaseResults) {
        val seperatedByPurchaseType = lotteryPurchaseResults.seperatedByPurchaseType()
        val manualLotteryCount = seperatedByPurchaseType[PurchaseType.MANUAL]?.lotteryTicket?.getNumbersCount() ?: 0
        val autoLotteryCount = seperatedByPurchaseType[PurchaseType.AUTO]?.lotteryTicket?.getNumbersCount() ?: 0
        println("수동으로 ${manualLotteryCount}장, 자동으로 ${autoLotteryCount}개를 구매했습니다.")
    }
}
