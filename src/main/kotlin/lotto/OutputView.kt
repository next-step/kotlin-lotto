package lotto

class OutputView {
    fun resultPrint(statistics: Statistics, allPrice: Int) {
        println(
            """
            
            당첨 통계
            ---------
            """.trimIndent()
        )

        println(
            """
            3개 일치 (5000원)- ${statistics.statistic[3]}개
            4개 일치 (50000원)- ${statistics.statistic[4]}개
            5개 일치 (1500000원)- ${statistics.statistic[5]}개
            6개 일치 (2000000000원)- ${statistics.statistic[6]}개
            총 수익률은 ${statistics.statistic(allPrice)}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
            """.trimIndent()
        )
    }
}
