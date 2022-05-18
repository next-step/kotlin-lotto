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

        context("숫자와 기본 구분자가 포함된 유효한 문자열을 입력받으면") {
            val input = "1,3:4"
            it("숫자의 합을 반환한다") {
                val calculator = StringAddCalculator()
                calculator.calculate(input) shouldBe 8
            }
        }
    }
})
