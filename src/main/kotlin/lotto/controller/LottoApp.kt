package lotto.controller

import lotto.domain.GeneratorLottoNumbers
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.ResultView

class LottoApp {
    private val inputView = InputView()
    private val resultView = ResultView()

    fun startLotto() {
        val count = inputView.inputUser()
        val tickets = GeneratorLottoNumbers().generateRandomLottoTickets(count)
        resultView.printBuyTickets(tickets)

        val winNumbers = inputView.inputWinNumbers()
        val winTicket = LottoTicket(winNumbers.map { LottoNumber(it) })
        resultView.printTicket(winTicket)

        val lottoResult = LottoResult(tickets, winTicket, count)
        resultView.printResult(lottoResult)
    }
}

fun main() {
    val lottoApp = LottoApp()
    lottoApp.startLotto()
}
