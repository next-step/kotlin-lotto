package lotto.view

import lotto.domain.Lottos
import lotto.domain.Results

object ResultView {

    fun showPurchaseAmounts(amounts: Int) {
        println("${amounts}개를 구매했습니다.")
    }

    fun showLottosDetail(lottos: Lottos) {
        println(lottos)
    }

    fun showResults(results: Results) {
        println("\n당첨 통계\n---------")
        println(results)
    }
}
