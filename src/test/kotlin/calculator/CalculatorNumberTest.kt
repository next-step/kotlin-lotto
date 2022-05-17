package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class CalculatorNumberTest : DescribeSpec({

    describe("constructor") {
        context("양수인 경우") {
            it("숫자를 생성한다") {
                CalculatorNumber(5) shouldNotBe null
            }
        }

        context("0인 경우") {
            it("숫자를 생성한다") {
                CalculatorNumber(0) shouldNotBe null
            }
        }

        context("음수인 경우") {
            it("IllegalArgumentException 예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    CalculatorNumber(-1)
                }
            }
        }
    }

    describe("plus") {
        context("두 숫자가 주어졌을 때 ") {
            it("합을 반환한다") {
                CalculatorNumber(5).plus(CalculatorNumber(4)) shouldBe CalculatorNumber(9)
            }

            it("연산자 기호를 통해 합을 반환한다") {
                CalculatorNumber(1) + (CalculatorNumber(4)) shouldBe CalculatorNumber(5)
            }
        }
    }

    describe("of") {
        context("올바른 숫자 문자열이 주어졌을 때") {
            it("숫자를 생성한다") {
                CalculatorNumber.of("5") shouldNotBe null
            }
        }

        context("숫자가 아닌 문자열이 주어졌을 때") {
            it("IllegalArgumentException 을 반환한다") {
                shouldThrow<IllegalArgumentException> {
                    CalculatorNumber.of("-")
                }
            }
        }

    }
})
