package lotto.view

import lotto.domain.Lotteries
import lotto.domain.LotteryMatchCount
import java.math.BigDecimal

object LotteryMachineOutputView {
    fun printLotteries(lotteries: Lotteries) {
        println("${lotteries.count()}개를 구매했습니다.")

        for (it in lotteries.lotteries) {
            println("[${it.numbers.map { it.value }.toList().joinToString(", ")}]")
        }
    }

    fun printResult(result: LotteryMatchCount, returnRate: BigDecimal) {
        println(
            """
        |당첨 통계
        |---------
        |3개 일치 (5000원)- ${result.matchCount[3] ?: 0}개
        |4개 일치 (50000원)- ${result.matchCount[4] ?: 0}개
        |5개 일치 (1500000원)- ${result.matchCount[5] ?: 0}개
        |6개 일치 (2000000000원)- ${result.matchCount[6] ?: 0}개
        |총 수익률은 ${returnRate}입니다.
            """.trimIndent()
        )
    }
}
