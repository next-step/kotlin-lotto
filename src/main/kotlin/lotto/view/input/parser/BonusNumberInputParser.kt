package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.LottoNumber
import lotto.model.data.Policy

open class BonusNumberInputParser(
    private val policy: Policy,
    private val lotto: Lotto
) : InputParser<LottoNumber> {

    private val intInputParser = IntInputParser(policy.rangeOfNumbers.toIntRange())

    override fun parseValue(inputString: String?): LottoNumber {
        val bonusNumberInt = intInputParser.parseValue(inputString)
        val bonusNumber = LottoNumber(bonusNumberInt)
        policy.validateWinningNumbers(this.lotto.numbers, bonusNumber)
        return bonusNumber
    }
}
