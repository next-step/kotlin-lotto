package lotto

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
        3개 일치 (5000원)- ${statistics.countOf(3)}개
        4개 일치 (50000원)- ${statistics.countOf(4)}개
        5개 일치 (1500000원)- ${statistics.countOf(5)}개
        6개 일치 (2000000000원)- ${statistics.countOf(6)}개
        총 수익률은 ${statistics.profitRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
        """.trimIndent()
        )
    }
}
