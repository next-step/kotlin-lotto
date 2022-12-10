package lotto.ui

import lotto.domain.LottoNumberValidator
import lotto.domain.MINIMUM_PRICE
import lotto.domain.model.WinningNumbers

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

    fun inputWinningNumbers(): WinningNumbers {
        println("")
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input = readlnOrNull() ?: ""

        val winningNumbers: WinningNumbers
        try {
            winningNumbers = WinningNumbers(winningNumberText = input)
        } catch (e: Exception) {
            return inputWinningNumbers()
        }

        return winningNumbers
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumberString = readlnOrNull() ?: ""
        val isBonusNumber = LottoNumberValidator.validateBonus(bonusNumberString)
        return if (isBonusNumber) {
            bonusNumberString.toInt()
        } else {
            inputBonusNumber()
        }
    }
}
