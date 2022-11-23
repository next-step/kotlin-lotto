package stringPlusCalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringInputConverterTest : DescribeSpec({
    describe("문자열 피연산자 변환 테스트") {
        it("음수가 아닌 정수 형식의 문자열 피연산자를 숫자로 변환할 수 있다.") {
            val stringOperands = listOf("1", "2", "3")
            val integerOperands = StringInputConverter.convert(stringOperands)

            integerOperands shouldBe listOf(1, 2, 3)
        }

        it("음수 형식의 문자열 피연산자는 RuntimeException 예외가 throw 된다.") {
            val stringOperands = listOf("-1", "2", "3")

            shouldThrow<RuntimeException> {
                StringInputConverter.convert(stringOperands)
            }
        }

        it("올바르지 않은 형식의 문자열 피연산자는 IllegalArgumentException 예외가 throw 된다.") {
            val stringOperands = listOf("/1", ";2", "3")

            shouldThrow<IllegalArgumentException> {
                StringInputConverter.convert(stringOperands)
            }
        }
    }
})
