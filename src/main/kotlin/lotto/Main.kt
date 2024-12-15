package lotto

import lotto.domain.LottoBunch
import lotto.domain.LottoNumber
import lotto.domain.PurchaseAmount
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val purchaseAmount = inputView.getPurchaseAmount() ?: return
    val purchaseCount = PurchaseAmount(purchaseAmount).getLottoCount()

    resultView.showPurchaseCount(purchaseCount)
    val lottoBunch = LottoBunch(purchaseCount)
    resultView.showPurchaseLotto(lottoBunch)

    val winningNumbers = inputView.getWinningNumbers() ?: return
    val winningLottoNumbers = winningNumbers.map { LottoNumber.get(it) }

    val bonusNumber = inputView.getBonusNumber() ?: return
    val bonusLottoNumber = LottoNumber.get(bonusNumber)

    resultView.showResultInterface()
    resultView.showMatchLottoResult(lottoBunch.getMatchLottoResult(winningLottoNumbers, bonusLottoNumber))
    resultView.showYield(lottoBunch.getYield(winningLottoNumbers, bonusLottoNumber, purchaseAmount))
}
