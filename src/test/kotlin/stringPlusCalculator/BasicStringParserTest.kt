package stringPlusCalculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BasicStringParserTest : DescribeSpec({
    describe("기본 문자열 파서 테스트") {
        it("쉼표를 통해서 문자열을 파싱할 수 있다.") {
            val expressionInput = "1,2"
            val parsedInput = BasicStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("1", "2")
        }

        it("콜론을 통해서 문자열을 파싱할 수 있다.") {
            val expressionInput = "1:2"
            val parsedInput = BasicStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("1", "2")
        }

        it("쉼표와 콜론을 통해서 문자열을 파싱할 수 있다.") {
            val expressionInput = "1,2:3"
            val parsedInput = BasicStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("1", "2", "3")
        }

        it("쉼표나 콜론이 유효하지 않을 경우 문자열을 파싱할 수 없다.") {
            val expressionInput = "1-2-3"
            val parsedInput = BasicStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("1-2-3")
        }
    }
})
