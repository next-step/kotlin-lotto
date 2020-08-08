package lotto

import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.Payment
import lotto.domain.Profit
import lotto.domain.WinningLotto
import lotto.domain.WinningResult
import lotto.view.ResultView.showQuantityPurchased
import lotto.view.ResultView.showLottosDetail
import lotto.view.ResultView.showResult
import lotto.view.InputView.getWinningNumber
import lotto.view.InputView.readBonusNumber
import lotto.view.InputView.readPayment
import lotto.view.InputView.readNumbers
import lotto.view.ResultView.showProfitRatio

fun main() {

    val payment = Payment(readPayment())
    showQuantityPurchased(payment.affordableQuantity())

    val lottoGame = LottoGame(payment)
    showLottosDetail(lottoGame.lottos)

    val winningNumbers = getWinningNumber(readNumbers())
    val bonus = LottoNumber(readBonusNumber())
    lottoGame.winningLotto = WinningLotto(winningNumbers, bonus)

    val ranks = lottoGame.startMatch()
    val result = WinningResult.resultOfRanks(ranks)
    showResult(result)

    val totalEarnings = Profit(WinningResult.sumOfPrizeMoney())
    val ratio = totalEarnings.calculateProfitRatio(payment)
    showProfitRatio(ratio)
}
