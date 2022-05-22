package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("Calculator") {
        it("입력받은 숫자의 합을 반환한다") {
            // given
            val calculator = Calculator(listOf(1, 2, 3))

            // when
            calculator.calculate()

            // then
            calculator.sum shouldBe 6
        }
    }
})
