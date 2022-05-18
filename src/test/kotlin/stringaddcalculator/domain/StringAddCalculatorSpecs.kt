package stringaddcalculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorSpecs : DescribeSpec({

    describe("문자열 덧셈 계산기는") {
        context("입력된 문자열이 null 이면") {
            val input: String? = null
            it("0을 반환한다") {
                val calculator = StringAddCalculator()
                calculator.calculate(input) shouldBe 0
            }
        }

        context("입력된 문자열이 비어있으면") {
            val input: String = ""
            it("0을 반환한다") {
                val calculator = StringAddCalculator()
                calculator.calculate(input) shouldBe 0
            }
        }
    }
})
