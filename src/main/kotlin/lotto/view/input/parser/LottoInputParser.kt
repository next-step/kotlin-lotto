package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.toLotto
import lotto.model.data.Policy
import lotto.util.toBlankRemovedIntList

class LottoInputParser(private val policy: Policy) : InputParser<Lotto> {

    override fun parseValue(inputString: String?): Lotto {

        require(!inputString.isNullOrBlank()) { "잘못된 입력입이다." }

        val numbers = inputString.toBlankRemovedIntList()
        val invalidNumbers = numbers.filter { it !in policy.rangeOfNumbers }
        val range = policy.rangeOfNumbers

        require(numbers.size == policy.countOfNumberToSelect) { " ${policy.countOfNumberToSelect} 개 숫자 입력이 필요합니다. " }
        require(invalidNumbers.isEmpty()) { " ${range.first} ~ ${range.last} 사이 숫자만 입력 가능합니다." }
        return numbers.toLotto()
    }
}
