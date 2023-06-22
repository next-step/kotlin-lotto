package lotto.view

import lotto.domain.Lotto
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
        println(result.toString())
    }
}