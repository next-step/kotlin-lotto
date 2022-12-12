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
        val numberOfManualLotto = InputFilter.inputNumberOfManualLotto(numberOfLotto)
        ResultView.printNumberOfLotto(numberOfLotto)
        val lottos = LottoGenerator.generateLottos(numberOfLotto)
        ResultView.printLottos(lottos.getList())

        val winningNumbers = InputFilter.inputWinningNumbers()
        val bonusNumber = InputFilter.inputBonusNumber()
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, bonusNumber)
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, lottos)
        val lottoResult = lottoResultGenerator.getResult()
        ResultView.printFinalResult(LottoResultDto(lottoResult))
    }
}
