package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.LottoShop
import lotto.domain.Payment
import lotto.domain.Profit
import lotto.domain.WinningResult
import lotto.view.InputView
import lotto.view.ResultView

fun main() {

    val payment = Payment(InputView.readPayment())
    var manualOrder = InputView.readManualOrder()
    var manualOrderHistory = manualOrder

    InputView.showTitleToGetManualNumbers()
    while (manualOrder > 0) {
        LottoShop.makeManualTicket(InputView.getManualNumbers())
        manualOrder--
    }

    ResultView.showOrderDetail(manualOrderHistory, payment.availableQuantity())

    val lottoGame = LottoGame(payment)
    ResultView.showLottosDetail(lottoGame.lottos)

    val winningNumbers = InputView.getWinningNumber(InputView.readWinningNumbers())
    val bonus = LottoNumber(InputView.readBonusNumber())

    val ranks = lottoGame.startMatch(winningNumbers, bonus)
    val result = WinningResult.resultOfRanks(ranks)
    ResultView.showResult(result)

    val totalEarnings = Profit(WinningResult.sumOfPrizeMoney())
    val ratio = totalEarnings.calculateProfitRatio(payment)
    ResultView.showProfitRatio(ratio)
}
