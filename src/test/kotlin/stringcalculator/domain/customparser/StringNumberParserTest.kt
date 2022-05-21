package stringcalculator.domain.customparser

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class StringNumberParserTest : DescribeSpec({
    it("Separators, 숫자가 포함된 문자열을 받아서 숫자를 추출한다") {
        // given
        val expression = "1,2:3"
        val ofStringExpression = ParserSeparators.ofStringExpression()
        val successNumbers = listOf(1, 2, 3)

        // when
        val stringNumberParser = CustomNumbersStringParser(
            expression, ofStringExpression
        )
        val parsedNumbers = stringNumberParser.parsedNumbers

        // then
        successNumbers shouldContainAll parsedNumbers
    }

    describe("validation") {
        it("Separators`(구분자들) 이 없는 경우 IllegalArgumentException 가 발생한다") {
            // given
            val expression = "1:2:3"

            // when
            val clearedSeparators = ParserSeparators.toEmpty()

            // then
            clearedSeparators.separators.size shouldBe 0
            shouldThrowExactly<java.lang.IllegalArgumentException> {
                CustomNumbersStringParser(expression, clearedSeparators)
            }.shouldHaveMessage("숫자를 추출하기 위한 구분자가 없습니다")
        }

        it("숫자, `Separators`(구분자들) 이외에 문자가 들어가 있는 경우 IllegalArgumentException 가 발생한다.") {
            // given
            val expression = "1Test2Test3"
            val separators = ParserSeparators.ofStringExpression()

            // then
            shouldThrowExactly<java.lang.IllegalArgumentException> {
                CustomNumbersStringParser(expression, separators)
            }.shouldHaveMessage("숫자, 구분 문자(:,,) 를 제외한 문자가 포함 되어 있습니다")
        }

        it("추출한 숫자가 음수 인 경우 IllegalArgumentException 발생") {
            // given
            val expression = "-1:2:3"
            val separators = ParserSeparators.ofStringExpression()

            // then
            shouldThrowExactly<java.lang.IllegalArgumentException> {
                CustomNumbersStringParser(expression, separators)
            }.shouldHaveMessage("음수(-1)은 입력할수 없습니다")
        }
    }
})
