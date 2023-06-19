package calculator

import calculator.domain.StringAddCalculator
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class StringAddCalculatorTest : BehaviorSpec({

    Given("StringAddCaluator에서") {
        val calculator = StringAddCalculator()
        When("빈 문자열 또는 null을 입력할 경우") {
            val operations = listOf(
                "",
                null
            )
            Then("0을 반환한다.") {
                operations.forAll { operation ->
                    val actual = calculator.execute(operation)
                    actual shouldBe 0
                }
            }
        }

        When("숫자 한개만 전달된 경우") {
            val operations = listOf(
                "1",
                "23",
                "456"
            )
            Then("해당 값을 반환한다.") {
                operations.forAll { operation ->
                    val actual = calculator.execute(operation)
                    actual shouldBe operation.toInt()
                }
            }
        }
    }
})
