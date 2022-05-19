package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.toLotto
import lotto.model.data.Policy

class LottoInputParser(private val policy: Policy) : InputParser<Lotto> {

    override fun parseValue(inputString: String?): Lotto {
        require(!inputString.isNullOrBlank()) { "잘못된 입력입이다." }
        return inputString.toLotto(policy)
    }
}
