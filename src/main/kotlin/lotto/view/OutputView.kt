package lotto.view

import lotto.domain.Lotto
import lotto.domain.prize.LottoPrize
import lotto.domain.prize.LottoPrizeResult

object OutputView {
    fun printNumberOfLottosBought(number: Int) {
        println("${number}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { println(it.numbers.list) }
    }

    fun printLottoPrizeStatistics(payment: Int, prizeResult: LottoPrizeResult) {
        println()
        println("당첨 통계")
        println("---------")
        printHitLottoPrizes(prizeResult)
        printProfitRate(payment, prizeResult.totalPrizeAmount)
    }

    private fun printHitLottoPrizes(prizeResult: LottoPrizeResult) {
        listOf(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST)
            .forEach { it.printStatistics(prizeResult.numberOf(it)) }
    }

    private fun LottoPrize.printStatistics(totalNumber: Int) {
        val bonusMatchString = when (matchesBonus) {
            true -> ", 보너스 볼 일치"
            false -> ""
        }
        println("${numberOfMatches}개 일치$bonusMatchString (${prizeAmount}원)- ${totalNumber}개")
    }

    private fun printProfitRate(payment: Int, totalPrizeAmount: Int) {
        val profitRate = totalPrizeAmount.toFloat() / payment
        val profitString = when {
            profitRate < 1 -> "손해"
            else -> "이득"
        }
        println("총 수익률은 ${String.format("%.2f", profitRate)}입니다.(기준이 1이기 때문에 결과적으로 ${profitString}라는 의미임)")
    }
}
