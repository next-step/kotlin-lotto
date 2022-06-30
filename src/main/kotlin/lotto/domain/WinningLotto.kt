package lotto.domain

import lotto.Const

data class WinningLotto(
    val winningTicket: LottoTicket,
    val bonusNumber: LottoNumber
) {

    init {
        require(bonusNumber !in winningTicket) { Const.ErrorMsg.INVALID_BONUS_NUMBER_ERROR_MSG }
    }

    constructor(winningNumbers: List<Int>, bonusNumber: Int) : this(
        LottoTicket(winningNumbers),
        LottoNumber(bonusNumber)
    )
}
