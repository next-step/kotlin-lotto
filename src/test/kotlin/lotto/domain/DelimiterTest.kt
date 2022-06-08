package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll

class DelimiterTest : DescribeSpec({
    it("구분자로 문자에서 숫자를 분리할수 있다") {
        // given
        val delimiterString = ","
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val numberDelimiterString = "1, 2, 3, 4, 5, 6"
        val delimiter = Delimiter(delimiterString)

        // when
        val parseNumbers = delimiter.parseNumbers(numberDelimiterString)

        // then
        numbers shouldContainAll parseNumbers
    }
})
