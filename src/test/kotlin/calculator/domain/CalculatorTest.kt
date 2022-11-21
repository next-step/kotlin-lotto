package calculator.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({
    val calculator = Calculator()

    given("덧셈 계산기에 문자열을 입력할 때") {
        `when`("커스텀 구분자를 포함하고") {
            val customSeparatorString = "//$CUSTOM_SEPARATOR\n"

            and("설정한 구분자로 구분된 숫자를 가진 문자열을 입력하면") {
                val numbers = listOf(1, 11, 0)
                val numbersString = numbers.joinToString(CUSTOM_SEPARATOR)

                then("기대한 값을 반환한다.") {
                    val result = calculator.calculate(customSeparatorString + numbersString)
                    result shouldBe numbers.sum()
                }
            }

            and("기본 구분자와 설정한 구분자로 구분된 숫자를 가진 문자열을 입력하면") {
                val numbersString = "1,111:2;3"
                then("기대한 값을 반환한다.") {
                    val result = calculator.calculate(customSeparatorString + numbersString)
                    result shouldBe 117
                }
            }
        }

        `when`("커스텀 구분자를 포함하지 않은 구분된 숫자를 입력하면") {
            val string = "1,2,3:55:8,10"
            then("기대한 값을 반환한다.") {
                val result = calculator.calculate(string)
                result shouldBe 79
            }
        }

        `when`("null 또는 공백문자를 입력하면") {
            NULL_OR_BLANK_STRING.forAll {
                then("0 을 반환한다.") {
                    val result = calculator.calculate(it)
                    result shouldBe ZERO
                }
            }
        }

        `when`("숫자 하나만 입력하면") {
            val number = "111"
            then("입력한 숫자를 반환한다.") {
                val result = calculator.calculate(number)
                result shouldBe 111
            }
        }
    }
}) {
    companion object {
        private const val ZERO = 0
        private const val CUSTOM_SEPARATOR = ";"
        private val NULL_OR_BLANK_STRING = listOf(null, "", " ")
    }
}
