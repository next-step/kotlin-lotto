package lotto.ui

class OutputView {
    fun printPurchasedAmount(purchased: Int) {
        println("$purchased 개를 구매했습니다.")
    }

    fun printLottoList(lottoList: List<List<Int>>) {
        lottoList.forEach { println(it) }
    }
}
