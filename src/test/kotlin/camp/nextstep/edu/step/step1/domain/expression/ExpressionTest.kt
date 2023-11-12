package camp.nextstep.edu.step.step1.domain.expression

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("입력값은")
class ExpressionTest : BehaviorSpec({

    Given("입력값이 주어지고") {
        val emptyInputValue = ""

        When("0또는 Null이 주어지면") {
            val emptyExpressionCreateException = shouldThrow<RuntimeException> {
                Expression(value = emptyInputValue)
            }

            Then("예외가 발생한다.") {
                emptyExpressionCreateException shouldBe RuntimeException()
            }
        }
    }

    Given("문자열이 주어졌을떄") {
        val expressionRequest = "1,2:3"

        When("쉼표 또는 콜론으로 구분되어 있으면") {
            val expression = Expression(value = expressionRequest)
            val splitExpression = expression.splitExpression()
            Then("쉼표 또는 콜론을 통해 문자열식을 분리한다.") {
                splitExpression.size shouldBe 3
                splitExpression shouldBe listOf("1", "2", "3")
            }
        }
    }

})
