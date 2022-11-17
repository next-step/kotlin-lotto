package lotto

import lotto.domain.LottoGame
import lotto.domain.WinnerTicket
import lotto.domain.LottoMachine
import lotto.domain.LottoTicketBulk
import lotto.dto.LottoTicketBulkDto
import lotto.view.InputView
import lotto.view.OutputView

class LottoMain {
}

fun main() {
    val amount = InputView.askPurchaseAmount()
    val manualPurchaseCount = InputView.askManualPurchaseCount()
    val manualLottoTicketNumbers = InputView.askManualLottoTicketNumbers(manualPurchaseCount)
    val manualLottoTicketBulk = LottoTicketBulk.of(manualLottoTicketNumbers)

    val autoPurchaseCount = LottoGame.purchaseTicket(amount) - manualPurchaseCount
    OutputView.printPurchase(autoPurchaseCount, manualPurchaseCount)
    val lottoMachine = LottoMachine()
    val autoLottoTicketBulk = lottoMachine.purchase(autoPurchaseCount)
    OutputView.printLottoNumbers(LottoTicketBulkDto(manualLottoTicketBulk + autoLottoTicketBulk))

    val winnerNumber = InputView.askWinnerNumber()
    val bonusNumber = InputView.askBonusNumber()

    val lottoGame = LottoGame(
        lottoTicketBulk = manualLottoTicketBulk + autoLottoTicketBulk,
        winnerTicket = WinnerTicket(winnerNumber, bonusNumber)
    )
    val winnerTickets = lottoGame.result()
    OutputView.printStatistics(winnerTickets.statistics(), winnerTickets.calculateProfitRate())
}

