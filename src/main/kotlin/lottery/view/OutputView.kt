package lottery.view

import lottery.domain.Lotto
import lottery.domain.Rank
import lottery.domain.Ranks

object OutputView {
    private const val PRINT_LOTTERY_AMOUNT_MESSAGE = "개를 구매했습니다."
    private const val SEPARATOR = ", "
    private const val PREFIX = "["
    private const val POSTFIX = "]"
    private const val WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------"
    private const val PRINT_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개"
    private const val PRINT_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다."
    private const val PRINT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    private const val PRINT_BENEFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"

    fun printLotteryInfo(lottos: List<Lotto>) {
        println("${lottos.size}$PRINT_LOTTERY_AMOUNT_MESSAGE")
        lottos.forEach { println(it.lottoNumber.joinToString(SEPARATOR, PREFIX, POSTFIX)) }
        println()
    }

    fun printResult(ranks: Ranks) {
        println(WINNING_STATISTICS_MESSAGE)
        (Rank.values().toList() - Rank.MISS).forEach {
            println(String.format(PRINT_RESULT_MESSAGE, it.countOfMatch, it.winningMoney, ranks.rank.count { rank -> rank == it }))
        }
        print(String.format(PRINT_RATE_OF_RETURN_MESSAGE, ranks.calculateProfitabilityRatio()))
        if (ranks.isProfitable()) println(PRINT_BENEFIT_MESSAGE) else println(PRINT_LOSS_MESSAGE)
    }
}
