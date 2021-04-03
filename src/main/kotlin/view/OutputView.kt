package view

import lotto.domain.LottoTickets
import lotto.domain.result.LottoResult

interface OutputView {
    fun printStringAdderInputMessage()

    fun printStringAdderResultMessage(result: Int)

    fun printPurchaseAmountMessage()

    fun printLottoTickets(autoTickets: LottoTickets, manualTickets: LottoTickets)

    fun printInputWinningNumbersMessage()

    fun printLottoResult(result: LottoResult)

    fun printInputBonusNumberMessage()

    fun printManualLottoCountMessage()

    fun printInputManualLottoNumbersMessage()
}
