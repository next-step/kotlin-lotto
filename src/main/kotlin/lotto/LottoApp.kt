package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.ResultView

class LottoApp

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val count = inputView.inputUser()
    val tickets = LottoTicket.generateLottoTickets(count)
    resultView.printBuyTickets(tickets)

    val winNumbers = inputView.inputWinNumbers()
    val winTicket = LottoTicket(winNumbers.map { LottoNumber(it) })
    resultView.printTicket(winTicket)

    val lottoResult = LottoResult(tickets, winTicket, count)
    resultView.printResult(lottoResult)
}
