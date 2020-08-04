package lotto.view

import lotto.domain.LottoShop
import lotto.domain.Lottos
import lotto.domain.Results

object ResultView {

    fun showSalesVolume(lottoShop: LottoShop) {
        println(lottoShop)
    }

    fun showLottosDetail(lottos: Lottos) {
        println(lottos)
    }

    fun showResults(results: Results) {
        println("\n당첨 통계\n---------")
        println(results)
    }
}
