package lotto

import lotto.domain.LottoPurchaseInfo
import lotto.domain.LottoResult
import lotto.domain.LottoTickets
import lotto.domain.WinningLottoTicket
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {
    fun run() {
        val money = InputView.getMoney()
        val manualLottoCount = InputView.getManualLottoCount()
        val manualNumbers = InputView.getManualNumbers(manualLottoCount)
        val lottoPurchaseInfo = LottoPurchaseInfo(money, manualLottoCount)

        val lottoTickets = LottoTickets(lottoPurchaseInfo, manualNumbers)
        ResultView.printLottoNumbers(lottoTickets)

        val winningLottoNumbers = InputView.getWinningLottoNumbers()
        val bonusNumber = InputView.getBonusNumber()

        val winningLottoTicket = WinningLottoTicket(winningLottoNumbers, bonusNumber)
        val result = LottoResult(winningLottoTicket, lottoTickets).getResult()
        ResultView.printResult(result)
    }
}
