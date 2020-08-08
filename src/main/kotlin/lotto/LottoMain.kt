package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.Payment
import lotto.domain.Profit
import lotto.domain.WinningLotto
import lotto.domain.WinningResult
import lotto.view.InputView
import lotto.view.ResultView

fun main() {

    val payment = Payment(InputView.readPayment())
    ResultView.showQuantityPurchased(payment.affordableQuantity())

    val lottoGame = LottoGame(payment)
    ResultView.showLottosDetail(lottoGame.lottos)

    val winningNumbers = InputView.getWinningNumber(InputView.readNumbers())
    val bonus = LottoNumber(InputView.readBonusNumber())
    lottoGame.winningLotto = WinningLotto(winningNumbers, bonus)

    val ranks = lottoGame.startMatch()
    val result = WinningResult.resultOfRanks(ranks)
    ResultView.showResult(result)

    val totalEarnings = Profit(WinningResult.sumOfPrizeMoney())
    val ratio = totalEarnings.calculateProfitRatio(payment)
    ResultView.showProfitRatio(ratio)
}
