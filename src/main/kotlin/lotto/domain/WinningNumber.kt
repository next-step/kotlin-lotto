package lotto.domain

import lotto.Const

class WinningNumber {
    fun winningNumberToLottoTicket(winningNumber: String?): LottoTicket {
        requireNotNull(winningNumber) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR }
        val winningNumbers = winningNumberToLottoNumberList(winningNumber)
        return LottoTicket(winningNumbers)
    }

    private fun winningNumberToLottoNumberList(winningNumber: String) =
        winningNumber.split(",").map {
            val number = requireNotNull(it.trim().toIntOrNull())
            LottoNumber(number)
        }.toSet()
}
