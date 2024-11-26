package lotto.view

import lotto.domain.LottoResult
import lotto.domain.LottoWinPlace
import lotto.model.Lotto

object ResultView {
    fun printTotalPurchaseCount(count: Int) {
        println("\n$count 개를 구매 했습니다.")
    }

    fun printLottoNumbers(list: List<Lotto>) {
        list.forEach { println(it) }
    }

    fun printLottoResult(result: LottoResult) {
        println("\n당첨 통계\n---------")
        val lottoResultMap = result.lottoResultMap
        LottoWinPlace.getPlacesFromLowest().forEach { winPlace ->
            println("${winPlace.matchingNumberCount}개 일치 (${winPlace.prizeMoney}원) - ${lottoResultMap[winPlace]}")
        }
    }

    fun printWinningRate(winningRate: Double) {
        println("\n총 수익률은 $winningRate 입니다.\n")
    }
}
