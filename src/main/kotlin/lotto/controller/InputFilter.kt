package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrice
import lotto.domain.Lottos
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

    fun inputLotto(): Lotto {
        return try {
            val parsedInput = InputParser.parseWithDelimiter(readln())
            Lotto(parsedInput.map { LottoNumber.from(it) })
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputLotto()
        }
    }

    fun inputLottos(count: Int): Lottos {
        return try {
            return Lottos(makeLottos(count))
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputLottos(count)
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

    private fun makeLottos(count: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (i in 1..count) {
            val parsedInput = InputParser.parseWithDelimiter(readln())
            val lotto = Lotto(parsedInput.map { LottoNumber.from(it) })
            lottos.add(lotto)
        }
        return lottos.toList()
    }
}
