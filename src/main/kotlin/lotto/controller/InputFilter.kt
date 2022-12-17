package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrice
import lotto.domain.Lottos
import lotto.domain.ManualLottoCount
import lotto.domain.WinningNumbers
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

    fun inputLottos(count: Int): Lottos {
        InputView.inputManualLottoNumber()
        return try {
            return Lottos(makeLottos(count))
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputLottos(count)
        }
    }

    fun inputWinningNumbers(): WinningNumbers {
        return try {
            val winningNumbers = inputLotto()
            val bonusNumber = inputBonusNumber()
            return WinningNumbers(winningNumbers, bonusNumber)
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputWinningNumbers()
        }
    }

    private fun makeLottos(count: Int): List<Lotto> {
        return List(count) {
            val parsedInput = InputParser.parseWithDelimiter(readln())
            Lotto(parsedInput.map { LottoNumber.from(it) })
        }
    }

    private fun inputLotto(): Lotto {
        InputView.inputWinningNumber()
        return try {
            val parsedInput = InputParser.parseWithDelimiter(readln())
            Lotto(parsedInput.map { LottoNumber.from(it) })
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputLotto()
        }
    }

    private fun inputBonusNumber(): LottoNumber {
        return try {
            LottoNumber.from(InputView.inputBonusNumber())
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputBonusNumber()
        }
    }
}
