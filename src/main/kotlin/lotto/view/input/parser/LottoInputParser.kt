package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.toLotto
import lotto.model.data.Policy
import lotto.util.toBlankRemovedIntList

class LottoInputParser(private val policy: Policy) : InputParser<Lotto> {

    override fun parseValue(inputString: String?): Lotto {
        require(!inputString.isNullOrBlank()) { "잘못된 입력입이다." }
        val numbers = inputString.toBlankRemovedIntList()
        return numbers.toLotto(policy)
    }
}
