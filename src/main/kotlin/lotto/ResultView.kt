package lotto

object ResultView {

    fun showAmountsSold(lottoShop: LottoShop) {
        println(lottoShop)
    }

    fun showLottoDetails(lottos: Lottos) {
        println(lottos)
    }

    fun showResults(results: Results) {
        println("\n당첨 통계\n---------")
        println(results)

    }
}
