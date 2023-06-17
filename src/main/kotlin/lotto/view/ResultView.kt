package lotto.view

import lotto.Lotto
import lotto.enums.LottoRank

object ResultView {

    fun printResult() {
        println("당첨 통계")
        println("---------")
    }

    fun printLottoCount(inputMoney: Int) {
        val buyCount = inputMoney / Lotto.ONE_PRICE
        println("${buyCount}개를 구매했습니다.")
    }

    fun printLottoBundle(lottoBundle: List<List<Int>>) {
        lottoBundle.forEach { println(it) }
    }

    fun printEnter() {
        println()
    }

    fun printRateOfReturn(returnRatio: Double) {
        print("총 수익률은 ${returnRatio}입니다.")

        if (returnRatio > 1) {
            println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)")
        } else {
            println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
        }
    }

    fun printWinningResult(resultGroup: Map<Int, Int>) {
        LottoRank.values().filter { it.count != 0 }.forEach { lotto ->
            resultGroup.keys.find { it == lotto.count }?.let {
                println("${it}개 일치 (${lotto.prizeMoney}원)- ${resultGroup[it]}개")
            } ?: println("${lotto.count}개 일치 (${lotto.prizeMoney}원)- 0개")
        }
    }
}
