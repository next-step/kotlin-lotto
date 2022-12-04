package lotto

object OutputView {
    fun printNumber(number: Int) {
        println("${number}개를 구매했습니다.")
    }

    fun print(any: Any) {
        println(any)
    }

    fun resultPrint(statistics: Statistics, allPrice: Int) {
        println(
            """
        
        당첨 통계
        ---------
        """.trimIndent()
        )

        val statistic = statistics.statistic(allPrice)
        println(
            """
        3개 일치 (5000원)- ${statistics.statistic[Rank.FIVE]}개
        4개 일치 (50000원)- ${statistics.statistic[Rank.FOUR]}개
        5개 일치 (1500000원)- ${statistics.statistic[Rank.THIRD]}개
        5개 일치, 보너스 볼 일치(30000000원)- ${statistics.statistic[Rank.SECOND]}개
        6개 일치 (2000000000원)- ${statistics.statistic[Rank.FIRST]}개
        총 수익률은 ${statistic}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
        """.trimIndent()
        )
    }
}
