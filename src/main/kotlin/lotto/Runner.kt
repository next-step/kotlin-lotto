package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoMachineResult
import lotto.view.InputView
import lotto.view.OutputView

fun main(args: Array<String>) {
    val purchaseInfo = InputView.makePurchaseInfo()
    val userLottoTickets = LottoMachine(purchaseInfo).makeLottoTickets()
    OutputView.printPurchasingLottoNumber(purchaseInfo, userLottoTickets)

    val winLottoInfo = InputView.makeWinLottoInfo()
    val lottoMachineResult = LottoMachineResult(userLottoTickets, winLottoInfo)
    OutputView.printWinnerStatistics(lottoMachineResult, purchaseInfo)
}
