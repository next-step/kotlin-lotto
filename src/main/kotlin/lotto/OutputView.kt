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
        ${Rank.FIVE.count}개 일치 (${Rank.FIVE.price}원)- ${statistics.statistic[Rank.FIVE]}개
        ${Rank.FOUR.count}개 일치 (${Rank.FOUR.price}원)- ${statistics.statistic[Rank.FOUR]}개
        ${Rank.THIRD.count}개 일치 (${Rank.THIRD.price}원)- ${statistics.statistic[Rank.THIRD]}개
        ${Rank.SECOND.count}개 일치, 보너스 볼 일치(${Rank.SECOND.price}원)- ${statistics.statistic[Rank.SECOND]}개
        ${Rank.FIRST.count}개 일치 (${Rank.FIRST.price}원)- ${statistics.statistic[Rank.FIRST]}개
        총 수익률은 ${statistic}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
        """.trimIndent()
        )
    }
}
