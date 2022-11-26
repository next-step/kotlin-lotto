package nextstep.mission.lotto.vo

import nextstep.mission.lotto.WinningPrize

@JvmInline
value class WinningResult(private val result: Map<WinningPrize, Int>) {

    fun getCount(winningPrize: WinningPrize): Int = result.getOrDefault(winningPrize, 0)

    fun rateOfReturn(totalPrice: Int): Double = WinningPrize.values()
        .sumOf { it.prize * getCount(it) }
        .let { it.toDouble() / totalPrice.toDouble() }
}
