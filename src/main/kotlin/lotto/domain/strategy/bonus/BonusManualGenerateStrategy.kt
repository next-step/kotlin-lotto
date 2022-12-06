package lotto.domain.strategy.bonus

import lotto.domain.LottoNumber
import lotto.domain.input.ClientInput
import lotto.extension.isPositiveNumeric

class BonusManualGenerateStrategy(
    private val clientInput: ClientInput
) : BonusGenerateStrategy {
    override fun generate(): LottoNumber {
        val bonusNumber = clientInput.read()
        validateBonusNumber(bonusNumber)
        return LottoNumber(bonusNumber.toInt())
    }

    private fun validateBonusNumber(bonusNumber: String) {
        require(bonusNumber.isPositiveNumeric()) { BONUS_NUMBER_ERROR }
    }

    companion object {
        const val BONUS_NUMBER_ERROR = "보너스 번호는 숫자로 이루어져 있어야 해요."
    }
}
