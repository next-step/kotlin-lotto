package calculator

import calculator.domain.InvalidOperationTokenException
import calculator.domain.OperationTokens
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class OperationTokensTest : BehaviorSpec({

    Given("OperationTokens") {
        When("자연수만 원소로 가질 때") {
            val tokenLists = listOf(
                listOf("1") to 1,
                listOf("12", "34") to 46,
                listOf("3", "4", "5") to 12
            )
            Then("sum()은 그 합을 반환한다.") {
                tokenLists.forAll { tokenList ->
                    OperationTokens(tokenList.first).sum() shouldBe tokenList.second
                }
            }
        }

        When("숫자가 아닌 값이나 음수가 주어졌을 때") {
            val inputs = listOf(
                listOf("1", "2", "-3"),
                listOf("1", "$"),
                listOf("-1", "2"),
                listOf("-3", "+")
            )
            Then("InvalidOperationTokenException 발생") {
                inputs.forAll { input ->
                    shouldThrow<InvalidOperationTokenException> {
                        OperationTokens(input)
                    }
                }
            }
        }
    }
})
