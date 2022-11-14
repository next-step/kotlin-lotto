package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoTicket
import lotto.domain.WinnerTicket
import lotto.util.LottoNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoMain {
}

fun main() {
    val amount = InputView.askPurchaseAmount()
    val purchaseCount = LottoGame.purchaseTicket(amount)
    OutputView.printPurchase(purchaseCount)
    val lottoNumberList = LottoNumberGenerator.generate(purchaseCount)
    OutputView.printLottoNumbers(lottoNumberList)

    val winnerNumber = InputView.askWinnerNumber()

    val lottoGame = LottoGame(
        lottoTickets = lottoNumberList.map { LottoTicket.of(it) },
        winnerTicket = WinnerTicket.of(winnerNumber)
    )
    val winnerTickets = lottoGame.pickWinnerTickets()
    OutputView.printStatistics(winnerTickets.statistics(), winnerTickets.calculateProfitRate())
}

