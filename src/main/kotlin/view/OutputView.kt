package view

import lotto.domain.LottoTickets

interface OutputView {
    fun printStringAdderInputMessage()

    fun printStringAdderResultMessage(result: Int)

    fun printPurchaseAmountMessage()

    fun printLottoTickets(tickets: LottoTickets)

    fun printInputWinningNumbersMessage()
}
