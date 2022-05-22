package lotto.view

class PrintView {
    fun printLottoCount(count: Int) {
        println("$count$LOTTO_COUNT_MESSAGE")
    }

    companion object {
        private const val LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    }
}