package lottery.view

import lottery.domain.Lotto
import lottery.domain.LottoMoney
import lottery.domain.Rank
import lottery.domain.Ranks

object OutputView {
    private const val PRINT_LOTTERY_AMOUNT_MESSAGE = "\n수동으로 %d장, 자동으로 %d장 구매했습니다."
    private const val PREFIX = "["
    private const val POSTFIX = "]"
    private const val WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------"
    private const val PRINT_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f입니다."
    private const val PRINT_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    private const val PRINT_BENEFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"

    fun printLotteryInfo(lottos: List<Lotto>, money: LottoMoney) {
        println(String.format(PRINT_LOTTERY_AMOUNT_MESSAGE, money.manualLottoCount, money.autoLottoCount))
        lottos.forEach { lotto -> println(PREFIX + lotto.lottoNumber.joinToString { it.lottoNumber.toString() } + POSTFIX) }
        println()
    }

    fun printResult(ranks: Ranks) {
        println(WINNING_STATISTICS_MESSAGE)
        Rank.getWinningRanks().forEach {
            println("${it.countOfMatch}개 일치${if (it == Rank.SECOND) ", 보너스 볼 일치" else " "}(${it.winningMoney}원) - ${ranks.rank.count { rank -> rank == it }}개")
        }
        print(String.format(PRINT_RATE_OF_RETURN_MESSAGE, ranks.profitMargin))
        if (ranks.isProfitable) println(PRINT_BENEFIT_MESSAGE) else println(PRINT_LOSS_MESSAGE)
    }
}
