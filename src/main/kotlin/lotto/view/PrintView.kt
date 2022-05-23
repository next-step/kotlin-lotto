package lotto.view

import lotto.domain.LottoResult

object PrintView {

    private const val LOTTO_NUMBER_PREFIX = "["
    private const val LOTT_NUMBER_POSTFIX = "]"
    private const val LOTTO_NUMBER_SEPARATOR = ", "
    private const val LOTTO_COUNT_MESSAGE = "개를 구매했습니다."

    private const val LOTTO_WIN_FORMAT = "%d개 일치(%d원)- %d개"
    private const val LOTTO_YIELD_RATIO_FORMAT = "총 수익률은 %.2f입니다."

    fun printLottoCount(count: Int) {
        println("$count$LOTTO_COUNT_MESSAGE")
    }

    fun printBoughtLottoList(boughtLotto: List<List<Int>>) {
        repeat(boughtLotto.size) { lottoIdx ->
            val lottoResult = boughtLotto[lottoIdx].joinToString(LOTTO_NUMBER_SEPARATOR)

            println("$LOTTO_NUMBER_PREFIX$lottoResult$LOTT_NUMBER_POSTFIX")
        }
    }

    fun printYield(yieldRatio: Double) {
        print(LOTTO_YIELD_RATIO_FORMAT.format(yieldRatio))
    }

    fun printWinnerInfos(result: List<LottoResult>) {
        result.forEach {
            val printResult = LOTTO_WIN_FORMAT.format(it.prize.matchCount, it.prize.money, it.count)

            println(printResult)
        }
    }
}
