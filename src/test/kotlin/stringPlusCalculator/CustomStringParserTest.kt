package stringPlusCalculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CustomStringParserTest : DescribeSpec({
    describe("커스텀 문자열 파서 테스트") {
        val customStringParser = CustomStringParser()

        it("커스텀 문자를 통해서 문자열을 파싱할 수 있다.") {
            val expressionInput = "//-\n1-2"
            val parsedInput = customStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("1", "2")
        }

        it("커스텀 문자열을 통해서 문자열을 파싱할 수 있다.") {
            val expressionInput = "//---\n1---2"
            val parsedInput = customStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("1", "2")
        }

        it("커스텀 문자가 유효하지 않을 경우 문자열을 파싱할 수 없다.") {
            val expressionInput = "//---\n1-;-2"
            val parsedInput = customStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("1-;-2")
        }

        it("커스텀 문자가 존재하지 않을 경우 문자열을 파싱할 수 없다.") {
            val expressionInput = "//---1-;-2"
            val parsedInput = customStringParser.parse(expressionInput)

            parsedInput shouldBe listOf("//---1-;-2")
        }
    }
})