package lotto

object ResultView {
    fun showPurchasedLotto(lottoList: List<Lotto>) {
        println("${lottoList.count()}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers)
        }
    }
}
