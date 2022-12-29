package plus_calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class StringAddCalculatorKoTest : DescribeSpec({
    val calculator = StringAddCalculator()

    describe("method test") {
        context("add Test") {
            listOf(null, "")
                .forEach {
                    it("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다") {
                        calculator.add(it) shouldBe 0
                    }
                }

            listOf("1", "2")
                .forEach {
                    it("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다") {
                        calculator.add(it) shouldBe it.toInt()
                    }
                }

            listOf("1,2" to 3, "2,3" to 5)
                .forEach { (expression, result) ->
                    it("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다") {
                        calculator.add(expression) shouldBe result
                    }
                }

            listOf("1,2:3" to 6, "2:3,4" to 9)
                .forEach { (expression, result) ->
                    it("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.") {
                        calculator.add(expression) shouldBe result
                    }
                }

            it("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다") {
                val message = shouldThrow<java.lang.RuntimeException> { calculator.add("-1") }

                message shouldHaveMessage "음수는 적용할 수 없습니다."
            }
        }
    }
})