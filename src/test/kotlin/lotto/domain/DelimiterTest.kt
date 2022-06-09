package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll

class DelimiterTest : DescribeSpec({
    describe("숫자를 추출할수 있다") {
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

        it("숫자가 아닌 문자가 포함되어 있는 경우 IllegalArgumentException 발생") {
            // given
            val delimiterString = ","
            val parseStringDelimiterString = "abc, 1, 2 , 3"
            val delimiter = Delimiter(delimiterString)

            // then
            shouldThrowExactly<IllegalArgumentException> {
                delimiter.parseNumbers(parseStringDelimiterString)
            }
        }
    }
})
