package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrice
import lotto.domain.ManualLottoCount
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

    fun inputNumberOfManualLotto(numberOfLotto: Int): ManualLottoCount {
        return try {
            ManualLottoCount(InputParser.parseNumberOfManualLotto(InputView.inputNumberOfManualLotto()), numberOfLotto)
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputNumberOfManualLotto(numberOfLotto)
        }
    }

    fun inputWinningNumbers(): Lotto {
        return try {
            val parsedInput = InputParser.parseWithDelimiter(InputView.inputWinningNumber())
            Lotto(parsedInput.map { LottoNumber.from(it) })
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputWinningNumbers()
        }
    }

    fun inputBonusNumber(): LottoNumber {
        return try {
            LottoNumber.from(InputView.inputBonusNumber())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputBonusNumber()
        }
    }
}
