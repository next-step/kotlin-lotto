package lotto.ui

import lotto.domain.LottoNumberValidator
import lotto.domain.MINIMUM_PRICE
import lotto.domain.model.LottoNumber

class InputView {

    fun inputPurchasingAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val amount = readlnOrNull()?.toIntOrNull() ?: 0
        return if (amount < MINIMUM_PRICE) {
            inputPurchasingAmount()
        } else {
            amount
        }
    }

    fun inputWinningNumbers(): String {
        println("")
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumberText = readlnOrNull() ?: ""
        return winningNumberText.ifBlank {
            inputWinningNumbers()
        }
    }

    fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumberString = readlnOrNull() ?: ""
        val isBonusNumber = LottoNumberValidator.validateBonus(bonusNumberString)
        return if (isBonusNumber) {
            LottoNumber(bonusNumberString.toInt())
        } else {
            inputBonusNumber()
        }
    }

    fun inputManualLottoCount(): Int {
        println()
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    fun inputManualLottoNumbers(manualCount: Int): List<String> {
        println()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(manualCount) {
            inputManualLottoNumber()
        }
    }

    private fun inputManualLottoNumber(): String {
        val lottoNumbersText = readlnOrNull() ?: ""
        return lottoNumbersText.ifBlank {
            inputManualLottoNumber()
        }
    }
}
