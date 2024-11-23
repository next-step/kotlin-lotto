package lotto

import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.WinningLottoTicket
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {
    fun run() {
        val lottoMoney = InputView.getLottoMoney()
        val manualLottoCount = InputView.getManualLottoCount()
        val manualNumbers = InputView.getManualNumbers(manualLottoCount)

        val lottoTickets = LottoTickets(lottoMoney, manualLottoCount, manualNumbers)
        ResultView.printLottoNumbers(lottoTickets)

        val winningLottoNumbers = InputView.getWinningLottoNumbers()
        val bonusNumber = InputView.getBonusNumber()

        val winningLottoTicket = WinningLottoTicket(winningLottoNumbers, bonusNumber)
        val result = LottoResult.getResult(winningLottoTicket, lottoTickets)
        ResultView.printResult(result)
    }
}