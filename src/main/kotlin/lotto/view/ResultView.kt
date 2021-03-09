package lotto.view

object ResultView {
    fun showPurchaseLottoCount(count: Int) {
        println("$count 개를 구매했습니다.")
    }

    fun showLotto(lottoNumber: String) {
        println("[$lottoNumber]")
    }

    fun showWinningStatistics() {
        println("당첨 통계")
        println("--------")
    }

    fun show4th(count: Int) {
        println("3개 일치 (5000원) - $count 개")
    }

    fun show3rd(count: Int) {
        println("4개 일치 (50000원) - $count 개")
    }

    fun show2nd(count: Int) {
        println("5개 일치 (15000000원) - $count 개")
    }

    fun show1st(count: Int) {
        println("6개 일치 (2000000000원) - $count 개")
    }

    fun showProfitRate(rate: Float) {
        println("총 수익률은 $rate 입니다.")
    }
}
