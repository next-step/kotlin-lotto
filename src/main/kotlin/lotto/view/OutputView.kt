package lotto.view

import lotto.domain.JackpotLevel
import lotto.domain.JackpotLevel.FIVE_MATCH_BONUS
import lotto.dto.JackpotDto
import lotto.dto.LottoDto

object OutputView {

    private const val ENTER_MONEY = "구입금액을 입력해 주세요."
    private const val LOTTO_COUNT = "개를 구매했습니다."
    private const val ENTER_JACKPOT_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val LOTTO_STATISTICS = "당첨 통계"
    private const val LINE = "---------"
    private const val SHOW_LOTTO_COUNT = 3
    private const val ROI = "총 수익률은 %.2f입니다."
    private const val BONUS_NUMBER = "보너스 볼을 입력해 주세요."

    fun printEnterMoney() = println(ENTER_MONEY)
    fun printLottoCount(count: String) = println(count + LOTTO_COUNT)
    fun printJackpotNumber() = println(ENTER_JACKPOT_NUMBER)
    fun printLottoStatistics() = println(LOTTO_STATISTICS)
    fun printLine() = println(LINE)
    fun printBonusNumber() = println(BONUS_NUMBER)

    fun printROI(roi: Double) {
        val message = ROI.format(roi)
        println(message)
    }

    fun printLottoList(lotto: List<LottoDto>) {
        lotto.forEach { lotto -> println(lotto.lotto.joinToString { "${it.number}" }) }
    }

    fun printResult(jackpot: List<JackpotDto>) {
        JackpotLevel.values()
            .filter { it.filterMatchingLevel(SHOW_LOTTO_COUNT) }
            .forEach { jackpotLevel ->
                val count = jackpot.count { it.jackpot.contains(jackpotLevel) }
                printMessage(jackpotLevel, count)
            }
    }

    private fun printMessage(jackpotLevel: JackpotLevel, count: Int) {
        if (jackpotLevel == FIVE_MATCH_BONUS) {
            println("${jackpotLevel.matchCount}개 일치, 보너스 볼 일치 (${jackpotLevel.price}원)- ${count}개")
        } else {
            println("${jackpotLevel.matchCount}개 일치 (${jackpotLevel.price}원)- ${count}개")
        }
    }
}
