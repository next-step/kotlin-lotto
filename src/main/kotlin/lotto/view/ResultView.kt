package lotto.view

import lotto.model.Lotto

class ResultView {
    fun printTotalPurchaseCount(count: Int) {
        println("\n$count 개를 구매 했습니다.")
    }

    fun printLottoNumbers(list: List<Lotto>) {
        list.forEach { println(it) }
    }

    fun printLottoResult(lottoResultMap: Map<Int, Int>) {
        println("\n당첨 통계\n---------")
        println("3개 일치 (5000원) - ${lottoResultMap.getOrDefault(3, 0)}")
        println("4개 일치 (50000원) - ${lottoResultMap.getOrDefault(4, 0)}")
        println("5개 일치 (1500000원) - ${lottoResultMap.getOrDefault(5, 0)}")
        println("6개 일치 (20억원) - ${lottoResultMap.getOrDefault(6, 0)}")
    }

    fun printWinningRate(winningRate: Float) {
        println("\n총 수익률은 $winningRate 입니다.\n")
    }
}
