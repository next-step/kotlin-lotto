package lotto.domain

import lotto.extension.isPositiveNumeric
import lotto.util.ExceptionMessage
import lotto.util.Reader

class BonusManualGenerateStrategy : BonusGenerateStrategy {
    override fun generate(): LottoNumber {
        val bonusNumber = Reader.read()
        validateBonusNumber(bonusNumber)
        return LottoNumber(bonusNumber.toInt())
    }

    private fun validateBonusNumber(bonusNumber: String) {
        require(bonusNumber.isPositiveNumeric()) { ExceptionMessage.BONUS_NUMBER_ERROR }
    }
}
