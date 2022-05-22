package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.Policy

open class BonusNumberInputParser(
    private val policy: Policy,
    private val lotto: Lotto
) : IntInputParser(policy.rangeOfNumbers) {

    override fun parseValue(inputString: String?): Int {
        val bonusNumber = super.parseValue(inputString)
        policy.validateWinningNumbers(this.lotto.numbers, bonusNumber)
        return bonusNumber
    }
}
