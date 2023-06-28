package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrizes
import lotto.domain.Lottos
import lotto.domain.WinningMap
import lotto.vo.LottosStatisticsVO

class ResultView {
    fun printPurchaseAmount(manualAmount: Int, autoAmount: Int) {
        println("\n수동으로 ${manualAmount}개, 자동으로 ${autoAmount}개를 구매했습니다.")
    }

    fun printLottos(lottos: Lottos) {
        lottos.lottos.forEach { printLotto(it) }
    }

    fun printWinningResult(statistics: LottosStatisticsVO) {
        printStatistics(statistics.prizeMap)
        printRateOfReturn(statistics.totalPrizeMoney, statistics.rateOfReturn)
    }

    private fun printLotto(lotto: Lotto) {
        val sortedNumbers = lotto.numbers.map { it.number }.sorted()
        println("[${sortedNumbers.joinToString(", ") { it.toString() }}]")
    }

    private fun printStatistics(winningMap: WinningMap) {
        println("\n당첨 통계")
        println("---------")

        LottoPrizes.values().forEach { prize ->
            printStatisticsByLottoPrizes(prize, winningMap.numberOfMatch(prize))
        }
    }

    private fun printStatisticsByLottoPrizes(prize: LottoPrizes, equalCount: Int) {
        if (prize === LottoPrizes.NONE) {
            return
        }

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
