package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView

object LottoGame {
    fun runGame() {
        val purchaseInfo = InputView.makePurchaseInfo()
        val userLottoTickets = LottoMachine(purchaseInfo).makeLottoTickets()
        OutputView.printPurchasingLottoNumber(userLottoTickets)

        val winLottoInfo = InputView.makeWinLottoInfo()
        val lottoMachineResult = LottoMachineResult(userLottoTickets, winLottoInfo)
        OutputView.printWinnerStatistics(lottoMachineResult, purchaseInfo)
    }
}
