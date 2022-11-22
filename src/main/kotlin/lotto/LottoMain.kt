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
    val winningLotto = WinningLotto(winningNumbers)
    println()

    val lottoStatistics = LottoStatistics(winningLotto.getMatchesCount(lottos), amount)
    LottoOutputView.printWinningStatistics(lottoStatistics)
}
