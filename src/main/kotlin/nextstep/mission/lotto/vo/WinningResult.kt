package nextstep.mission.lotto.vo

import nextstep.mission.lotto.WinningPrize

@JvmInline
value class WinningResult(private val result: Map<WinningPrize, Int>) {

    fun getCount(winningPrize: WinningPrize): Int = result.getOrDefault(winningPrize, 0)
}
