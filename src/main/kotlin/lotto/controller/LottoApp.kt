package lotto.controller

import lotto.domain.GeneratorLottoNumbers
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.domain.LottoWinner
import lotto.view.InputView
import lotto.view.ResultView

class LottoApp {
    private val inputView = InputView()
    private val resultView = ResultView()

    fun startLotto() {
        val count = inputView.inputUser()
        val manualTickets = inputView.inputManualTickets()
        val autoTicketCount = count - manualTickets.size
        val tickets = GeneratorLottoNumbers.generateRandomLottoTickets(autoTicketCount)
        resultView.printBuyTickets(
            manualTickets.size,
            autoTicketCount,
            manualTickets + tickets,
        )

        val winNumbers = inputView.inputWinNumbers()
        val winTicket = LottoTicket(winNumbers.map { LottoNumber(it) })
        resultView.printTicket(winTicket)

        val bonusNumber = inputView.inputBonusNumber()

        val lottoResult = LottoResult(tickets, LottoWinner(winTicket, LottoNumber(bonusNumber)), count)
        resultView.printResult(lottoResult)
    }
}

fun main() {
    val lottoApp = LottoApp()
    lottoApp.startLotto()
}
