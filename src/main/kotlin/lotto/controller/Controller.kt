package lotto.controller

import lotto.application.LottoGenerator
import lotto.application.LottoResultGenerator
import lotto.domain.WinningNumbers
import lotto.dto.LottoResultDto
import lotto.view.ResultView

object Controller {
    fun start() {
        val amountOfPurchase = InputFilter.inputAmountOfPurchase()
        val numberOfLotto = amountOfPurchase.calculateNumberOfLotto()
        val numberOfManualLotto = InputFilter.inputNumberOfManualLotto(numberOfLotto).manualLottoCount
        val manualLottos = InputFilter.inputLottos(numberOfManualLotto)

        ResultView.printNumberOfLotto(numberOfLotto, numberOfManualLotto)
        val lottos = LottoGenerator.generateLottos(numberOfLotto - numberOfManualLotto, manualLottos)
        ResultView.printLottos(lottos.getList())

        val winningNumbers = InputFilter.inputLotto()
        val bonusNumber = InputFilter.inputBonusNumber()
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, bonusNumber)
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, lottos)
        val lottoResult = lottoResultGenerator.getResult()
        ResultView.printFinalResult(LottoResultDto(lottoResult))
    }
}
