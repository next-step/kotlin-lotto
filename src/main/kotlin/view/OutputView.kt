package view

import lotto.domain.LottoTickets
import lotto.domain.result.LottoResult

interface OutputView {
    fun printStringAdderInputMessage()

    fun printStringAdderResultMessage(result: Int)

    fun printPurchaseAmountMessage()

    fun printLottoTickets(tickets: LottoTickets)

    fun printInputWinningNumbersMessage()

    fun printLottoResult(result: LottoResult)

    fun printInputBonusNumberMessage()
}
