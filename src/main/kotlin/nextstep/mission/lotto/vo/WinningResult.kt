package nextstep.mission.lotto.vo

import nextstep.mission.lotto.WinningPrize

@JvmInline
value class WinningResult(private val result: Map<WinningPrize, Int>)
