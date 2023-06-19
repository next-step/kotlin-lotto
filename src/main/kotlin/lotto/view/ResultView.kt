package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrizes
import lotto.domain.LottosStatistics

class ResultView {
    fun printPurchaseAmount(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { printLotto(it) }
    }

    fun printWinningResult(statistics: LottosStatistics) {
        printStatistics(statistics.prizeMap)
        printRateOfReturn(statistics.totalPrizeMoney, statistics.rateOfReturn)
    }

    private fun printLotto(lotto: Lotto) {
        val numbers = lotto.numbers.map { it.number }.sorted()
        println("[${numbers.joinToString(", ")}]")
    }

    private fun printStatistics(prizeMap: Map<LottoPrizes, Int>) {
        println("\n당첨 통계")
        println("---------")

        LottoPrizes.values().forEach { prize ->
            printStatisticsByLottoPrizes(prize, prizeMap.getOrDefault(prize, 0))
        }
    }

    private fun printStatisticsByLottoPrizes(prize: LottoPrizes, equalCount: Int) {
        if (prize === LottoPrizes.MATCH_FIVE_PRIZES_WITH_BONUS) {
            return println("${prize.equalCount}개 일치, 보너스 볼 일치(${prize.money}원)- ${equalCount}개")
        }
        println("${prize.equalCount}개 일치 (${prize.money}원)- ${equalCount}개")
    }

    private fun printRateOfReturn(totalPrizeMoney: Int, rateOfReturn: Double) {
        if (totalPrizeMoney == 0) {
            return println("총 수익률은 0입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }

        val textRateOfReturn = "%.3f".format(rateOfReturn).take(4)

        return when {
            rateOfReturn > 1.0 -> println("총 수익률은 ${textRateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)")
            rateOfReturn == 1.0 -> println("총 수익률은 ${textRateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 본전이라는 의미임)")
            else -> println("총 수익률은 ${textRateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }
}
