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
    val manualOrder = InputView.readManualOrder()

    val manualLottos = InputView.getManualLottos(manualOrder)
    val lottoShop = LottoShop(payment, manualLottos)
    ResultView.showOrderDetail(manualOrder, payment.availableQuantity())

    val lottoGame = LottoGame(lottoShop)
    ResultView.showLottosDetail(lottoGame.lottos)

    val winningNumbers = InputView.getWinningNumbers(InputView.readWinningNumbers())
    val bonus = LottoNumber(InputView.readBonusNumber())

    val ranks = lottoGame.startMatch(winningNumbers, bonus)
    val result = WinningResult.resultOfRanks(ranks)
    ResultView.showResult(result)

    val totalEarnings = Profit(WinningResult.sumOfPrizeMoney())
    val ratio = totalEarnings.calculateProfitRatio(payment)
    ResultView.showProfitRatio(ratio)
}
