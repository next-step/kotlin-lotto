package lotto.view

object ResultView {
    fun printPurchaseAmount(purchaseAmount: Int) {
        println("${purchaseAmount}개를 구매했습니다.")
    }

    fun printLottoList(lottoList: List<List<Int>>) {
        for (lotto in lottoList) {
            val numbers = lotto.joinToString(", ")
            println("[$numbers]")
        }
        println()
    }
}
