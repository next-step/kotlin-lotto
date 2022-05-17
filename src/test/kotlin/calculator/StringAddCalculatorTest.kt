package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : DescribeSpec({
    val calculator = StringAddCalculator

    describe("calculate") {
        context("null 을 입력할 경우") {
            it("0을 반환해야 한다") {
                calculator.calculate(null) shouldBe 0
            }
        }

        context("빈 문자열을 입력한 경우") {
            it("0을 반환해야 한다") {
                calculator.calculate("") shouldBe 0
            }
        }

        context("숫자 하나를 문자열로 입력할 경우") {
            it("해당 숫자를 반환한다") {
                calculator.calculate("5") shouldBe 5
            }
        }

        context("숫자 두개를 쉼표(,) 구분자로 입력할 경우") {
            it("두 숫자의 합을 반환한다") {
                calculator.calculate("1,2") shouldBe 3
            }

            it("여러 숫자의 합을 반환한다") {
                calculator.calculate("1,2,3,4,5") shouldBe 15
            }
        }

        context("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다") {
            it("콜론만 사용한 사용한다") {
                calculator.calculate("1:4:7") shouldBe 12
            }

            it("쉼표와 콜론을 함께 사용한다") {
                calculator.calculate("1:2,5:4,10") shouldBe 22
            }
        }

        context("//와 n 사이에 커스텀 구분자를 지정할 수 있다") {
            it("커스텀 구분자를 ;로 사용한다") {
                calculator.calculate("//;\n1;2;3") shouldBe 6
            }
        }

        context("문자열 계산기에 음수를 전달하는 경우") {
            it("RuntimeException 예외 처리를 한다") {
                shouldThrow<IllegalArgumentException> {
                    calculator.calculate("-1,1")
                }
            }
        }
    }
})
