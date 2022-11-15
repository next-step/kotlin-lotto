package lotto

import lotto.domain.LottoGame
import lotto.domain.WinnerTicket
import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

class LottoMain {
}

fun main() {
    val amount = InputView.askPurchaseAmount()
    val purchaseCount = LottoGame.purchaseTicket(amount)
    OutputView.printPurchase(purchaseCount)
    val lottoMachine = LottoMachine()
    val lottoTicketBulk = lottoMachine.purchase(purchaseCount)
    OutputView.printLottoNumbers(lottoTicketBulk)

    val winnerNumber = InputView.askWinnerNumber()

    val lottoGame = LottoGame(
        lottoTicketBulk = lottoTicketBulk,
        winnerTicket = WinnerTicket.of(winnerNumber)
    )
    val winnerTickets = lottoGame.result()
    OutputView.printStatistics(winnerTickets.statistics(), winnerTickets.calculateProfitRate())
}

