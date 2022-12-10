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
        ResultView.printNumberOfLotto(numberOfLotto)
        val lottoNumbersList = LottoGenerator.generateLottoNumbers(numberOfLotto)
        ResultView.printLottoNumbersList(lottoNumbersList.getList())

        val winningNumbers = InputFilter.inputWinningNumbers()
        val bonusNumber = InputFilter.inputBonusNumber()
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, bonusNumber)
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, lottoNumbersList)
        val lottoResult = lottoResultGenerator.getResult()
        ResultView.printFinalResult(LottoResultDto(lottoResult))
    }
}
