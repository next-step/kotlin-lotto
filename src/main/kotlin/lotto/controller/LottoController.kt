package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoResults
import lotto.domain.LottoStore
import lotto.domain.ManualLottoNumbers
import lotto.domain.TotalRate
import lotto.domain.Wallet
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {

    fun start() {
        val wallet = Wallet(inputView.inputBudget())
        val manualLottoNumberTexts = inputView.inputManualLotto()
        val manualLottoNumbers = ManualLottoNumbers.generateManualLottoNumbers(manualLottoNumberTexts)
        val manualLottoSize = manualLottoNumbers.getManualLottoNumberSize()
        val autoLottoNumberSize = wallet.getAbleToBuyAutoLottoCounts(manualLottoSize)
        val lottos = LottoStore().sellLotto(
            autoLottoNumberSize,
            manualLottoNumbers
        )

        resultView.viewPurchaseLotto(lottos, autoLottoNumberSize, manualLottoSize)
        val winningNumber = LottoNumbers.generateLottoNumbers(inputView.inputWinningNumber())
        val bonusNumber = LottoNumber.ofBonusNumber(inputView.inputBonusNumber(), winningNumber)
        val lottoResults = LottoResults.matchingWinningNumber(winningNumber, bonusNumber, lottos)
        resultView.viewLottoResults(lottoResults, TotalRate.calculatingOf(lottoResults).getBenefit())
    }
}
