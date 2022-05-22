package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorNumberTest : DescribeSpec({
    describe("CalculatorNumber") {
        it("정상적인 입력을 반환한다.") {
            // given
            val result = CalculatorNumber(3)

            // then
            result.num shouldBe 3
        }

        it("음수를 전달하는 경우 RuntimeException 예외를 throw 한다.") {
            val exception = shouldThrow<RuntimeException> {
                CalculatorNumber(null)
            }

            exception.message shouldBe "숫자가 아닌 다른 값이 올 수 없습니다."
        }

        it("문자열 계산기에 숫자 이외의 값인 경우 RuntimeException 예외를 throw 한다.") {
            val exception = shouldThrow<RuntimeException> {
                CalculatorNumber(-1)
            }

            exception.message shouldBe "음수 값이 올 수 없습니다."
        }
    }
})
