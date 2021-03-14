package lotto.domain

import lotto.supportdata.PurchaseInfo
import lotto.supportdata.WinNumber
import lotto.view.InputView
import lotto.view.OutputView

object LottoGame {
    fun runGame() {
        val purchaseInfo = PurchaseInfo(InputView.purchase())
        val userLottoTickets = LottoMachine(purchaseInfo).makeLottoTickets()
        OutputView.printPurchasingLottoNumber(userLottoTickets)

        val winNumber = WinNumber(InputView.winNumber())
        val lottoMachineResult = LottoMachineResult(userLottoTickets, winNumber)
        OutputView.printWinnerStatistics(lottoMachineResult, purchaseInfo)
    }
}
