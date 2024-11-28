package lotto.application

import lotto.domain.Lotto

data class PlayLottoCommand(
    val lotto: Lotto,
    val winner: WinnerInfo,
    val payment: Long,
)

data class WinnerInfo(
    val line: List<Int>,
    val bonusBall: Int,
)
