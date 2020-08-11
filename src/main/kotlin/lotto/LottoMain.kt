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
    val manualOrder = InputView.readManualOrder(payment.availableQuantity())

    val manualLottos = InputView.getManualLottos(manualOrder)
    ResultView.showOrderDetail(payment.availableQuantity(), manualOrder)

    val userLottos = LottoShop.sellTickets(payment, manualLottos)
    ResultView.showLottosDetail(userLottos)

    val winningNumbers = InputView.getWinningNumbers(InputView.readWinningNumbers())
    val bonus = LottoNumber.of(InputView.readBonusNumber())

    val lottoGame = LottoGame(userLottos)
    val ranks = lottoGame.startMatch(winningNumbers, bonus)
    val result = WinningResult.resultOfRanks(ranks)
    ResultView.showResult(result)

    val totalEarnings = Profit(WinningResult.sumOfPrizeMoney())
    val ratio = totalEarnings.calculateProfitRatio(payment)
    ResultView.showProfitRatio(ratio)
}
