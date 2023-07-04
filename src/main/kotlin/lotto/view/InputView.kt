package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

object InputView {
    private const val INPUT_PURCHASE_PRICE_STRING = "구입금액을 입력해 주세요."
    private const val PRICE_ONLY_NUMBER_ALERT = "로또 가격은 숫자만 가능합니다."
    private const val INPUT_PREVIOUS_LOTTO_NUMBER_STRING = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER_STRING = "보너스 볼을 입력해 주세요."
    private const val INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val LOTTO_COUNT_NOT_NUMBER_ALERT = "로또의 수는 숫자만 가능합니다."
    private const val INPUT_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요."

    fun inputPurchasePrice(): Int {
        println(INPUT_PURCHASE_PRICE_STRING)
        val lottoPrice = readln()

        return lottoPrice.toIntOrNull()
            ?: run {
                println(PRICE_ONLY_NUMBER_ALERT)
                inputPurchasePrice()
            }
    }

    fun inputWinningLotto(): WinningLotto {
        println(INPUT_PREVIOUS_LOTTO_NUMBER_STRING)
        val winningNumbers = inputLotto()
        val bonusNumber = inputBonusNumber()

        return WinningLotto(Lotto.of(winningNumbers), bonusNumber)
    }

    private fun inputManualLottoCount(): Int {
        println(INPUT_MANUAL_LOTTO_COUNT)
        val lottoCount = readln()

        return lottoCount.toIntOrNull()
            ?: run {
                println(LOTTO_COUNT_NOT_NUMBER_ALERT)
                inputManualLottoCount()
            }
    }

    fun inputManualLottos(): LottoList {
        val lottoCount = inputManualLottoCount()
        println(INPUT_MANUAL_LOTTO)
        val lottos = List(lottoCount) { Lotto.of(inputLotto()) }

        return LottoList(lottos)
    }

    private fun inputLotto(): List<Int> {
        return LottoNumberParser.splitInputLottoNumbers(readln())
    }

    private fun inputBonusNumber(): LottoNumber {
        println(INPUT_BONUS_NUMBER_STRING)
        val inputNumber = LottoNumberParser.validateLottoNumber(readln())

        return LottoNumber(inputNumber)
    }
}
