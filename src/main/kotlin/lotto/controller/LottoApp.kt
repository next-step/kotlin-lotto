package lotto.controller

import lotto.domain.GeneratorLottoNumbers
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.LottoTicket
import lotto.domain.LottoWinner
import lotto.view.InputView
import lotto.view.ResultView

class LottoApp {
    fun startLotto() {
        val count = InputView.inputUser()
        val manualTickets = InputView.inputManualTickets()
        val autoTicketCount = count - manualTickets.size
        val autoTickets = GeneratorLottoNumbers.generateRandomLottoTickets(autoTicketCount)
        val totalTickets = manualTickets + autoTickets

        ResultView.printBuyTickets(
            manualTickets.size,
            autoTicketCount,
            totalTickets,
        )

        val winNumbers = InputView.inputWinNumbers()
        val winTicket = LottoTicket(winNumbers.map { LottoNumber(it) })
        ResultView.printTicket(winTicket)

        val bonusNumber = InputView.inputBonusNumber()

        val lottoResult = LottoResult(totalTickets, LottoWinner(winTicket, LottoNumber(bonusNumber)), count)
        ResultView.printResult(lottoResult)
    }
}

fun main() {
    val lottoApp = LottoApp()
    lottoApp.startLotto()
}
