package lotto.controller

import lotto.domain.LottoFactory
import lotto.domain.LottoStatistics
import lotto.domain.Lottos
import lotto.domain.WinningLotto
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

class LottoController {
    fun play() {
        val lottos = purchaseLotto()
        getWinningLotto(lottos)
    }

    private fun purchaseLotto(): Lottos {
        val amount = LottoInputView.inputPurchaseAmount()

        val countOfManual = LottoInputView.inputCountOfManualLotto(amount)

        val manualLottos = LottoInputView.inputManualLottoNumbers(countOfManual)

        val lottos = LottoFactory.purchaseLotto(amount, manualLottos)
        LottoOutputView.printPurchaseLottoResult(lottos, manualLottos)
        return lottos
    }

    private fun getWinningLotto(lottos: Lottos) {
        val winningNumbers = LottoInputView.inputWinningNumbersOfLastWeek()
        val bonusNumber = LottoInputView.inputBonusNumberOfLastWeek()
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val lottoStatistics = LottoStatistics(winningLotto.getMatchResult(lottos))
        LottoOutputView.printWinningStatistics(lottoStatistics)
    }
}

fun main() {
    LottoController().play()
}
