package stringPlusCalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringPlusCalculatorTest  : DescribeSpec({
    describe("문자열 덧셈 계산기 테스트") {
        it("빈문자열을 입력할 경우 0을 리턴한다.") {
            val expressionInput = ""

            StringPlusCalculator.calculate(expressionInput) shouldBe 0
        }

        it("하나의 숫자를 문자열로 입력할 경우 해당 숫자를 리턴한다.") {
            val expressionInput = "6"

            StringPlusCalculator.calculate(expressionInput) shouldBe 6
        }

        it("두개의 숫자를 콤마를 구분하여 문자열을 입력할 경우 해당 숫자의 합을 리턴한다.") {
            val expressionInput = "1,2"

            StringPlusCalculator.calculate(expressionInput) shouldBe 3
        }

        it("두개의 숫자를 콜론을 구분하여 문자열을 입력할 경우 해당 숫자의 합을 리턴한다.") {
            val expressionInput = "1:2"

            StringPlusCalculator.calculate(expressionInput) shouldBe 3
        }

        it("두개의 숫자를 커스텀 문자열로 구분하여 문자열을 입력할 경우 해당 숫자의 합을 리턴한다.") {
            val expressionInput = "//-\n1-2-3"

            StringPlusCalculator.calculate(expressionInput) shouldBe 6
        }

        it("음수를 포함한 문자열을 입력할 경우 RuntimeException 에러를 throw 한다.") {
            val expressionInput = "-1,2"

            shouldThrow<RuntimeException> {
                StringPlusCalculator.calculate(expressionInput)
            }
        }

        it("허용되지 않는 문자열을 입력할 경우 IllegalArgumentException 에러를 throw 한다.") {
            val expressionInput = "ㅅ1,/2"

            shouldThrow<IllegalArgumentException> {
                StringPlusCalculator.calculate(expressionInput)
            }
        }
    }
})