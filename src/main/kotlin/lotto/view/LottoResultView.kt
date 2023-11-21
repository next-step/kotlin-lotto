package lotto.view

import lotto.model.LottoPrize
import lotto.model.LottoResult
import java.util.TreeMap

class LottoResultView {
    fun printLottoResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        printLottoPrizes(lottoResult)
        printRevenueRate(lottoResult)
    }

    private fun printLottoPrizes(lottoResult: LottoResult) {
        lottoResult
            .groupByLottoPrize()
            .forEach { (lottoPrize, ticketCount) -> printLottoPrize(lottoPrize, ticketCount) }
    }

    private fun LottoResult.groupByLottoPrize(): TreeMap<LottoPrize, Int> {
        val source = lottoPrizes
            .filter { it != LottoPrize.MISS }
            .groupingBy { it }
            .eachCount()

        val result = TreeMap<LottoPrize, Int>(Comparator.reverseOrder())

        result.putAll(printTargetLottoPrizeMap + source)

        return result
    }

    private fun printLottoPrize(lottoPrize: LottoPrize, ticketCount: Int) {
        val message = if (lottoPrize == LottoPrize.SECOND) {
            "${lottoPrize.matchedCount}개 일치(보너스 번호 당첨) (${lottoPrize.prize}원)- ${ticketCount}개"
        } else {
            "${lottoPrize.matchedCount}개 일치 (${lottoPrize.prize}원)- ${ticketCount}개"
        }

        println(message)
    }

    private fun printRevenueRate(lottoResult: LottoResult) {
        println("총 수익률은 ${lottoResult.revenueRate}입니다.\n")
    }

    companion object {
        private val printTargetLottoPrizeMap: Map<LottoPrize, Int> = LottoPrize.values()
            .filter { it != LottoPrize.MISS }
            .associateWith { 0 }
    }
}
