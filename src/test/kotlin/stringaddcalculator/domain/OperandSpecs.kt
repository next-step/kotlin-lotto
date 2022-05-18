package stringaddcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class OperandSpecs : DescribeSpec({

    describe("피연산자는") {
        it("숫자를 가질 수 있다.") {
            Operand(10).value shouldBe 10
        }
    }
})
