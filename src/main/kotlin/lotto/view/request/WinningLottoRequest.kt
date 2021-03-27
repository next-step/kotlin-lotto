package lotto.view.request

import lotto.domain.ticket.WinningLottoCreator

data class WinningLottoRequest(
    val numbers: String,
    val bonusNumber: Int
) {
    fun toWinningLottoCreator(): WinningLottoCreator {
        return WinningLottoCreator(
            numbers = numbers,
            bonusNumber = bonusNumber)
    }
}
