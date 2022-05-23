package lotto.view.input.parser

import lotto.model.data.CommaSeparatedInt
import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.parseToLotto
import lotto.model.data.ParseResult
import lotto.model.data.Policy

class LottoInputParser(private val policy: Policy) : InputParser<Lotto> {

    override fun parseValue(inputString: String?): ParseResult<Lotto> =
        CommaSeparatedInt(inputString).parseToLotto(policy)
}
