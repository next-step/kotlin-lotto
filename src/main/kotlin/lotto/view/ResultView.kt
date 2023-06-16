package lotto.view

object ResultView {
    fun endGameForCannotBuy() {
        println("로또를 구매할 수 없어 게임을 종료합니다")
    }

    fun showBuyResult(lottoCount: Int, buyedLotto: List<List<Int>>) {
        println("${lottoCount}개를 구매했습니다.")
        buyedLotto.forEach {
            println(it)
        }
    }
}
