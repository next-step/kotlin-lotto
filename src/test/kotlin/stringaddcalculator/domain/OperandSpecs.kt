package stringaddcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class OperandSpecs : DescribeSpec({

    describe("피연산자는") {
        it("숫자인 값을 가질 수 있다.") {
            Operand(10).value shouldBe 10
        }
        it("다른 피연산자와 더할 수 있다.") {
            Operand(1) + Operand(2) shouldBe Operand(3)
        }
    }
})
