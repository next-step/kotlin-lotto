package lotto

import lotto.domain.LottoFactory
import lotto.domain.LottoStatistics
import lotto.domain.WinningLotto
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

fun main() {
    val amount = LottoInputView.inputPurchaseAmount()
    println(amount)
    val lottos = LottoFactory.purchaseLotto(amount)
    LottoOutputView.printPurchaseLottoResult(lottos)

    val winningNumbers = LottoInputView.inputWinningNumbersOfLastWeek()
    val bonusNumber = LottoInputView.inputBonusNumberOfLastWeek()
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    println()

    val lottoStatistics = LottoStatistics(winningLotto.getMatchResult(lottos))
    LottoOutputView.printWinningStatistics(lottoStatistics)
}
