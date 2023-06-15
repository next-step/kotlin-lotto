package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoPrizes

class ResultView {
    fun printPurchaseAmount(amount: Int) {
        println("${amount}개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach { printLotto(it) }
    }

    fun printWinningStatistics(countsMap: Map<Int, Int>) {
        println("\n당첨 통계")
        println("---------")

        LottoPrizes.values().forEach { prize ->
            val equalCount = countsMap.getOrDefault(prize.equalCount, 0)
            val prizeMoney = LottoPrizes.getMoney(prize.equalCount)
            println("${prize.equalCount}개 일치 (${prizeMoney}원)- ${equalCount}개")
        }
    }

    fun printRateOfReturn(budget: Int, prizes: Int) {
        if (prizes == 0) {
            return println("총 수익률은 0입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }

        val rateOfReturn = prizes.toDouble() / budget.toDouble()
        val textRateOfReturn = "%.3f".format(rateOfReturn).take(4)

        return when {
            rateOfReturn > 1.0 -> println("총 수익률은 ${textRateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)")
            rateOfReturn == 1.0 -> println("총 수익률은 ${textRateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 본전이라는 의미임)")
            else -> println("총 수익률은 ${textRateOfReturn}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }

    private fun printLotto(lotto: Lotto) {
        val numbers = lotto.numbers.sorted()
        println("[${numbers.joinToString(", ")}]")
    }
}
