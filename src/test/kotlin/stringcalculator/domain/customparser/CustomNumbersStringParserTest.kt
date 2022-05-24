package stringcalculator.domain.customparser

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll

class CustomNumbersStringParserTest : DescribeSpec({
    it("구분자, 숫자가 포함된 문자열을 받아서 숫자를 추출한다") {
        // given
        val expression = "1,2:3"
        val ofStringExpression = ParserSeparators(listOf(ParserSeparator(","), ParserSeparator(":")))

        // when
        val stringNumberParser = CustomNumbersStringParser(
            expression, ofStringExpression
        )
        val parsedNumbers = stringNumberParser.parsedPositiveNumbers.map { it.value }

        // then
        val successNumbers = listOf(1, 2, 3)
        successNumbers shouldContainAll parsedNumbers
    }
})
