package stringcalculator.domain.customparser

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.throwable.shouldHaveMessage

class CustomNumberExpressionTest : DescribeSpec({
    describe("validation") {
        it("숫자, `ParserSeparators`(구분자들) 이외에 문자가 들어가 있는 경우 IllegalArgumentException 가 발생한다.") {
            // given
            val expressionString = "1Test2Test3"
            val separators = ParserSeparators(listOf(ParserSeparator(","), ParserSeparator(":")))

            // then
            shouldThrowExactly<IllegalArgumentException> {
                CustomNumberExpression(expressionString, separators)
            }.shouldHaveMessage("숫자, 구분 문자(,,:) 를 제외한 문자가 포함 되어 있습니다")
        }
    }
})
