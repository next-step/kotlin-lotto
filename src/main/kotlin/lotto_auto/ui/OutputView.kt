package lotto_auto.ui

import lotto_auto.lotto.Lotto
import lotto_auto.lotto.LottoPrize

object OutputView {
    fun print(list: List<Lotto>) {
        list.forEach {
            println(it.numberList.lottoNumbers)
        }
    }

    fun showResult(matchResult: Map<LottoPrize, Int>, earningRate: Float) {
        println(LOTTO_STAT)
        println("---------")
        println(MATCH_THREE.format(matchResult.getOrDefault(LottoPrize.FIFTH_PRIZE, LottoPrize.MISS)))
        println(MATCH_FOUR.format(matchResult.getOrDefault(LottoPrize.FOURTH_PRIZE, LottoPrize.MISS)))
        println(MATCH_FIVE.format(matchResult.getOrDefault(LottoPrize.THIRD_PRIZE, LottoPrize.MISS)))
        println(MATCH_FIVE_WITH_BONUS.format(matchResult.getOrDefault(LottoPrize.SECOND_PRIZE, LottoPrize.MISS)))
        println(MATCH_SIX.format(matchResult.getOrDefault(LottoPrize.FIRST_PRIZE, LottoPrize.MISS)))
        println(TOTAL_EARNING_RATE.format(earningRate))
    }

    private const val LOTTO_STAT = "당첨 통계"
    private const val MATCH_THREE = "3개 일치 (5000원) - %d개"
    private const val MATCH_FOUR = "4개 일치 (50000원 ) - %d개"
    private const val MATCH_FIVE = "5개 일치 (1500000원) - %d개"
    private const val MATCH_FIVE_WITH_BONUS = "5개 일치, 보너스볼 일치 (30000000원) - %d개"
    private const val MATCH_SIX = "6개 일치 (2000000000원) - %d개"
    private const val TOTAL_EARNING_RATE = "총 수익률은 %.2f 입니다."
}
