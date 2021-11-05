package lotto.controller

import lotto.domain.LottoResults
import lotto.domain.LottoStore
import lotto.domain.TotalRate
import lotto.domain.Wallet
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {

    fun start() {
        val wallet = Wallet(inputView.inputBudget())
        val manualLottoNumberTexts = inputView.inputManualLotto()
        val lottoStore = LottoStore.purchaseLotto(wallet, manualLottoNumberTexts)
        resultView.viewPurchaseLotto(lottoStore)
        val winningNumber = inputView.inputWinningNumber()
        val bonusNumber = inputView.inputBonusNumber()
        val lottoResults = LottoResults.matchingWinningNumber(winningNumber, bonusNumber, lottoStore.getAllLottos())
        resultView.viewLottoResults(lottoResults, TotalRate.calculatingOf(lottoResults).getBenefit())
    }
}
