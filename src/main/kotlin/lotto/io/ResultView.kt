package lotto.io

import lotto.domain.LottosResult
import lotto.domain.WinLottoResults

object ResultView {
    private const val LOTTO_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다."
    private const val WINNING_PRIZE_MESSAGE = "%d개 일치 (%d원)- %d개"
    private const val WINNING_PRIZE_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원) - %d개"
    private const val TOTAL_PRIZE_MESSAGE = "총 수익률은 %.2f입니다"
    private const val RESULT_MESSAGE = "\n당첨 통계\n---------"
    private const val MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."

    fun printLottos(lottosResult: LottosResult) {
        println(LOTTO_COUNT_MESSAGE.format(lottosResult.manualLottoSize, lottosResult.autoLottoSize))
        lottosResult.forEach { lotto -> println(lotto) }
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

    fun printManualLottoInputMessage() {
        println(MANUAL_LOTTO_INPUT_MESSAGE)
    }
}
