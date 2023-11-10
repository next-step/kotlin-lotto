package lotto.ui

import lotto.lotto.Lotto
import lotto.lotto.LottoPrize

object OutputView {
    fun printRequestEnterManualLottoNumber() {
        println()
        println(ENTER_MANUAL_LOTTO_NUMBER)
    }

    fun printTotalLottoCount(manualLottoCount: Int, autoLottoCount: Int) {
        println(BUY_COUNT.format(manualLottoCount, autoLottoCount))
    }

    fun printAutoLottoList(list: List<Lotto>) {
        list.forEach {
            println(it.numberList.lottoNumbers)
        }
    }

    fun showResult(matchResult: Map<LottoPrize, Int>, earningRate: Float) {
        println(LOTTO_STAT)
        println("---------")
        matchResult.map { result ->
            val prize = result.key
            val matchCount = result.value
            val defaultAmount = LottoPrize.MISS.winningAmount
            val matchedString = findMatchedString(prize)
            val formatMatchedString = matchedString.format(matchCount, defaultAmount)
            // match nothing은 보여주지 않습니다.
            if (matchedString != MATCH_NOTHING) println(formatMatchedString)
        }
        println(TOTAL_EARNING_RATE.format(earningRate))
    }

    private fun findMatchedString(prize: LottoPrize): String = when (prize) {
        LottoPrize.FIFTH_PRIZE -> MATCH_THREE
        LottoPrize.FOURTH_PRIZE -> MATCH_FOUR
        LottoPrize.THIRD_PRIZE -> MATCH_FIVE
        LottoPrize.SECOND_PRIZE -> MATCH_FIVE_WITH_BONUS
        LottoPrize.FIRST_PRIZE -> MATCH_SIX
        else -> MATCH_NOTHING
    }

    private const val ENTER_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
    private const val BUY_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다."
    private const val LOTTO_STAT = "당첨 통계"
    private const val MATCH_NOTHING = "0개 일치"
    private const val MATCH_THREE = "3개 일치 (5000원) - %d개"
    private const val MATCH_FOUR = "4개 일치 (50000원 ) - %d개"
    private const val MATCH_FIVE = "5개 일치 (1500000원) - %d개"
    private const val MATCH_FIVE_WITH_BONUS = "5개 일치, 보너스볼 일치 (30000000원) - %d개"
    private const val MATCH_SIX = "6개 일치 (2000000000원) - %d개"
    private const val TOTAL_EARNING_RATE = "총 수익률은 %.2f 입니다."
}
