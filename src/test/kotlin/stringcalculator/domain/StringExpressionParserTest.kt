package stringcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll

class StringExpressionParserTest : DescribeSpec({
    it("연산식에서 구분자, 숫자 문자열을 분리한다") {
        // given
        val expression = "1,2:3"
        val successParsedNumbers = listOf(1, 2, 3)

        // when
        val stringExpressionParser = StringExpressionParser(expression)
        val parsedNumber = stringExpressionParser.getParsedNumber()

        // then
        parsedNumber shouldContainAll successParsedNumbers
    }

    it("커스텀 구분자가 포함된 연산식에서 커스텀 구분자, 숫자를 추출할수 있다") {
        // given
        val expression = "//;\n1;2;3"
        val successParsedNumbers = listOf(1, 2, 3)

        // when
        val stringExpressionParser = StringExpressionParser(expression)
        val parsedNumber = stringExpressionParser.getParsedNumber()

        // then
        parsedNumber shouldContainAll successParsedNumbers
    }
})
