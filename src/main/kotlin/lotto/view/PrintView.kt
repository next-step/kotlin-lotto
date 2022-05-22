package lotto.view

class PrintView {
    fun printLottoCount(count: Int) {
        println("$count$LOTTO_COUNT_MESSAGE")
    }

    fun printBoughtLottoList(boughtLotto: List<List<Int>>) {
        repeat(boughtLotto.size) { lottoIdx ->
            val lottoResult = boughtLotto[lottoIdx].joinToString(LOTTO_NUMBER_SEPARATOR)

            println("$LOTTO_NUMBER_PREFIX$lottoResult$LOTT_NUMBER_POSTFIX")
        }
    }

    companion object {
        private const val LOTTO_NUMBER_PREFIX = "["
        private const val LOTT_NUMBER_POSTFIX = "]"
        private const val LOTTO_NUMBER_SEPARATOR = ", "
        private const val LOTTO_COUNT_MESSAGE = "개를 구매했습니다."
    }
}