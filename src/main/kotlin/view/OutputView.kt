package view

import lotto.domain.LottoTicket

interface OutputView {
    fun printStringAdderInputMessage()

    fun printStringAdderResultMessage(result: Int)

    fun printPurchaseAmountMessage()

    fun printLottoTickets(tickets: List<LottoTicket>)
}
