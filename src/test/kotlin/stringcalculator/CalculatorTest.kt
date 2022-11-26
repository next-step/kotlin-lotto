package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FeatureSpec({

    feature("fun addAll()") {
        val calculator = Calculator()

        scenario(",또는: 으로 구분된 숫자 문자열을 입력하면 모두 더한 값을 반환한다.") {
            val input = "1,2:3"
            val expectResult = 6

            calculator.addAll(input) shouldBe expectResult
        }

        scenario("//와 \n 사이에 커스텀 구분자를 입력하면, 해당 구분자로 구분하여 모두 더한 값을 반환한다.") {
            val input = "//;\n1;2;3"
            val expectResult = 6

            calculator.addAll(input) shouldBe expectResult
        }

        scenario("null 또는 빈 문자열을 입력할 경우 0을 반환한다.") {
            val inputs = listOf(null, "")
            val expectResult = 0

            inputs.forEach { input ->
                calculator.addAll(input) shouldBe expectResult
            }
        }

        scenario("숫자 하나를 입력할 경우 해당 숫자를 반환한다.") {
            val input = "13"
            val expectResult = 13

            calculator.addAll(input) shouldBe expectResult
        }

        scenario("음수를 입력한 경우 RuntimeException을 반환한다.") {
            val input = "1,2:-13"

            shouldThrowExactly<RuntimeException> { calculator.addAll(input) }
        }
    }
})
