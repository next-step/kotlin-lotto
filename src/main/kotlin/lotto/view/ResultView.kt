package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.Statistics

object ResultView {
    fun printLottos(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.map { it.numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") }
            .forEach { println(it) }
    }

    fun printStatistic(statistics: Statistics) {
        println(
            """
        당첨 통계
        ---------
        3개 일치 (5000원)- ${statistics.countOf(Rank.FIFTH)}개
        4개 일치 (50000원)- ${statistics.countOf(Rank.FOURTH)}개
        5개 일치 (1500000원)- ${statistics.countOf(Rank.THIRD)}개
        5개 일치, 보너스 볼 일치 (30000000원)- ${statistics.countOf(Rank.SECOND)}개
        6개 일치 (2000000000원)- ${statistics.countOf(Rank.FIRST)}개
        총 수익률은 ${statistics.profitRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
        """.trimIndent()
        )
    }
}
