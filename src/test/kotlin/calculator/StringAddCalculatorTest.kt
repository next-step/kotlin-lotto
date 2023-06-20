package calculator

import calculator.domain.InvalidOperationTokenException
import calculator.domain.StringAddCalculator
import io.kotest.assertions.throwables.shouldThrow
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

        When("숫자 두개를 쉼표 구분자로 전달된 경우") {
            val inputs = listOf(
                "1,3" to 4,
                "23,41" to 64,
                "100,101" to 201
            )
            Then("해당 값을 반환한다.") {
                inputs.forAll { input ->
                    val actual = calculator.execute(input.first)
                    actual shouldBe input.second
                }
            }
        }

        When("숫자 이외의 값이 전달된 경우") {
            val inputs = listOf(
                "1,+",
                "$",
                "//~\n1~3~@"
            )
            Then("InvalidOperationTokenException 오류 발생") {
                inputs.forAll { input ->
                    shouldThrow<InvalidOperationTokenException> { calculator.execute(input) }
                }
            }
        }
    }
})
