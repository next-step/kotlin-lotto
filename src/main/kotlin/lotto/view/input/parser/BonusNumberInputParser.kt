package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.Policy
import lotto.model.data.WinningLotto.Companion.toWinningLotto

open class BonusNumberInputParser(
    private val policy: Policy,
    private val lotto: Lotto
) : IntInputParser(policy.rangeOfNumbers) {

    override fun parseValue(inputString: String?): Int {
        val bonusNumber = super.parseValue(inputString)
        this.lotto.toWinningLotto(policy, bonusNumber)
        return bonusNumber
    }
}
