package lotto.io

import lotto.domain.Lottos
import lotto.domain.WinLottoResults

object ResultView {
    private const val LOTTO_COUNT_MESSAGE = "%d개 구매했습니다"
    private const val WINNING_PRIZE_MESSAGE = "%d개 일치 (%d원)- %d개"
    private const val WINNING_PRIZE_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개"
    private const val TOTAL_PRIZE_MESSAGE = "총 수익률은 %.2f입니다"
    private const val RESULT_MESSAGE = "\n당첨 통계\n---------"

    fun printLottos(lottos: Lottos) {
        println(LOTTO_COUNT_MESSAGE.format(lottos.size))
        lottos.forEach { lotto -> println(lotto) }
        println()
    }

    fun printResult(results: WinLottoResults) {
        println(RESULT_MESSAGE)
        for (result in results) {
            val template = if (result.bonusMatch) WINNING_PRIZE_WITH_BONUS_MESSAGE else WINNING_PRIZE_MESSAGE
            println(template.format(result.matchCount, result.prize, result.count))
        }

        println(TOTAL_PRIZE_MESSAGE.format(results.rateOfReturn))
    }
}
