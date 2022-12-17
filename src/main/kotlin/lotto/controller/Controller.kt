package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.LottoResultGenerator
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

        val winningNumbersWithBonusNumber = InputFilter.inputWinningNumbers()
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, lottos)
        val lottoResult = lottoResultGenerator.getResult()
        ResultView.printFinalResult(LottoResultDto(lottoResult))
    }
}
