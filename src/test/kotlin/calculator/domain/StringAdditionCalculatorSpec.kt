package calculator.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringAdditionCalculatorSpec : DescribeSpec({
    describe("문자열 덧셈 계산기") {
        context("입력 문자열이 정상인 경우 (w/ 기본 구분자)") {
            val ts = listOf(
                null to 0,
                "" to 0,
                "1" to 1,
                "1,2" to 3,
                "1,2,3" to 6,
                "1,2:3" to 6,
                "1,2:3,4" to 10,
            )

            withData(
                nameFn = { "입력 문자열 `${it.first}`의 계산 결과는 ${it.second} 이다." },
                ts = ts,
            ) { (input, answer) ->
                StringCalculator.calculate(input) shouldBe answer
            }
        }

        context("입력 문자열이 정상인 경우 (w/ 커스텀 구분자)") {
            val ts = listOf(
                null to 0,
                "//;\n1" to 1,
                "//;\n1;2;3" to 6,
                "//#\n1#2#3#4" to 10,
            )

            withData(
                nameFn = { "입력 문자열 `${it.first}`의 계산 결과는 ${it.second} 이다." },
                ts = ts,
            ) { (input, answer) ->
                StringCalculator.calculate(input) shouldBe answer
            }
        }

        context("숫자 이외의 값이 전달된 경우") {
            it("RuntimeException 예외를 throw 한다.") {
                shouldThrowExactly<RuntimeException> {
                    StringCalculator.calculate("%,2")
                }
            }
        }

        context("음수 값이 전달된 경우") {
            it("RuntimeException 예외를 throw 한다.") {
                shouldThrowExactly<RuntimeException> {
                    StringCalculator.calculate("1,2:3,4,5:6,7,8,9,-10")
                }
            }
        }
    }
})
