package view

import domain.Lottery
import domain.Prize

object OutputView {

    fun reportPrizeState(lottery: Lottery) {
        println(lottery.lotteryNumbers.toString())
    }

    fun reportProfit(returnOnInvestment: Double) {
        val formattedROI = "%.2f".format(returnOnInvestment)
        val message = if (returnOnInvestment > 1) {
            "이익을 얻었습니다."
        } else {
            "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
        println("총 수익률은 ${formattedROI}입니다.$message")
    }

    fun reportPurchaseCount(manualSize: Int, purchasableSize: Int) {
        println("\n수동으로 ${manualSize}장, 자동으로 ${purchasableSize}개를 구매했습니다.")
    }

    fun reportPrizes(prizeCountMap: Map<Int, Int>) {
        for (prize in Prize.values()) {
            val count = prizeCountMap[prize.matches] ?: 0
            println("${prize.prizeMessage}- ${count}개")
        }
    }
}
