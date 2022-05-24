package lotto.ui

import lotto.Lotto
import lotto.StatResult

class ResultView {

    fun buyCount(count: Int) {
        println("$count" + BUY_COUNT_TEXT)
    }

    fun lottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { println(it.numbers) }
    }

    fun result(resultList: List<StatResult>) {
        println(WINING_STAT_TEXT)
        resultList.forEach {
            println(it.matchState.descriptor.format(it.count))
        }
    }

    fun yields(yields: Double) {
        println(TRY_COUNT_TEXT.format(yields))
    }

    companion object {
        private const val BUY_COUNT_TEXT = "개를 구매했습니다."
        private const val WINING_STAT_TEXT = "\n당첨 통계\n---------"
        private const val TRY_COUNT_TEXT = "총 수익률은 %s입니다."
    }
}
