package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoResult

class ResultView {

    fun displayPurchasedLotto(lottoList: List<Lotto>) {
        displayNumOfLotto(lottoList.size)
        lottoList.forEach { println(it.toString()) }
        println()
    }

    fun displayNumOfLotto(number: Int) {
        println("$number 개를 구매했습니다.")
    }

    fun displayResult(result: LottoResult) {
        println("당첨 통계")
        println("---------")
        LottoRank.ranks().forEach {
            val cnt = result.rankCntMap.getOrDefault(it, 0)
            println("${it.numOfMatch}" + "개 일치 (${it.winningMoney}" + "원)- $cnt" + "개\n")
        }
        println("총 수익률은 ${String.format("%.2f", result.rateOfReturn)}" + "입니다. " + result.message)
    }
}
