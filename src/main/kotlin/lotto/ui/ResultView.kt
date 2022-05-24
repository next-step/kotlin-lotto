package lotto.ui

import lotto.Lotto

class ResultView {

    fun buyCount(count: Int) {
        println("$count" + BUY_COUNT_TEXT)
    }

    fun lottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { println(it.numbers) }
    }

    companion object {
        private const val BUY_COUNT_TEXT = "개를 구매했습니다."
        private const val WINING_STAT_TEXT = "당첨 통계"
        private const val TRY_COUNT_TEXT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    }
}
