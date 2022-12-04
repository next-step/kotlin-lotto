package lotto.controller

import lotto.application.LottoResultGenerator
import lotto.domain.InputParser
import lotto.domain.LottoGenerator
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoNumbersList
import lotto.domain.LottoPrice
import lotto.domain.WinningNumbers
import lotto.dto.LottoResultDto
import lotto.view.InputView
import lotto.view.ResultView

object Controller {
    fun start() {
        val amount = inputAmount()
        val numberOfLotto = amount.calculateNumberOfLotto()
        ResultView.printNumberOfLotto(numberOfLotto)
        val lottoNumbersList = generateLottoNumbers(numberOfLotto)
        ResultView.printLottoNumbersList(lottoNumbersList.getList())

        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        val winningNumbersWithBonusNumber = WinningNumbers(winningNumbers, bonusNumber)
        val lottoResultGenerator = LottoResultGenerator(winningNumbersWithBonusNumber, lottoNumbersList)
        val lottoResult = lottoResultGenerator.getResult()
        ResultView.printFinalResult(LottoResultDto(lottoResult))
    }

    private fun generateLottoNumbers(lottoCount: Int): LottoNumbersList {
        val lottoNumbersList = mutableListOf<LottoNumbers>()
        repeat(lottoCount) {
            val lottoNumbers = LottoGenerator.generate()
            lottoNumbersList.add(lottoNumbers)
        }
        return LottoNumbersList(lottoNumbersList)
    }

    private fun inputAmount(): LottoPrice {
        return try {
            LottoPrice(InputView.inputAmount())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputAmount()
        }
    }

    private fun inputWinningNumbers(): LottoNumbers {
        return try {
            val parsedInput = InputParser.parseWithDelimiter(InputView.inputWinningNumber())
            LottoNumbers(parsedInput.map { LottoNumber(it) })
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputWinningNumbers()
        }
    }

    private fun inputBonusNumber(): LottoNumber {
        return try {
            LottoNumber(InputView.inputBonusNumber())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputBonusNumber()
        }
    }
}
