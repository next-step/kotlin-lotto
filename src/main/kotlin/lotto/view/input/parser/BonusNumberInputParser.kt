package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.LottoNumber
import lotto.model.data.ParseResult
import lotto.model.data.Policy

open class BonusNumberInputParser(
    private val policy: Policy,
    private val lotto: Lotto
) : InputParser<LottoNumber> {

    private val intInputParser = IntInputParser(policy.rangeOfNumbers.toIntRange())

    override fun parseValue(inputString: String?): ParseResult<LottoNumber> =
        when (val parsedBonusNumber = intInputParser.parseValue(inputString)) {
            is ParseResult.Error -> ParseResult.Error(parsedBonusNumber.error)
            is ParseResult.Value -> parseValue(LottoNumber(parsedBonusNumber.value))
        }

    private fun parseValue(bonusNumber: LottoNumber): ParseResult<LottoNumber> =
        when (val error = policy.validateWinningNumbers(this.lotto.numbers, bonusNumber)) {
            null -> ParseResult.Value(bonusNumber)
            else -> ParseResult.Error(error)
        }
}
