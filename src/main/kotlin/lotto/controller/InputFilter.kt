package lotto.controller

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoPrice
import lotto.view.InputView

object InputFilter {
    fun inputAmountOfPurchase(): LottoPrice {
        return try {
            LottoPrice(InputView.inputAmount())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputAmountOfPurchase()
        }
    }

    fun inputWinningNumbers(): LottoNumbers {
        return try {
            val parsedInput = InputParser.parseWithDelimiter(InputView.inputWinningNumber())
            LottoNumbers(parsedInput.map { LottoNumber(it) })
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputWinningNumbers()
        }
    }

    fun inputBonusNumber(): LottoNumber {
        return try {
            LottoNumber(InputView.inputBonusNumber())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputBonusNumber()
        }
    }
}
