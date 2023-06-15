package cacluator.domain

import calculator.domain.ExpressionFactory
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : BehaviorSpec({
    given("유효한 식이 있다") {
        val input = "1,2:3,4"
        `when`("해당문자열의 합을 계산하면") {
            then("합계를 반환한다") {
                val expression = ExpressionFactory.createExpression(input)
                expression.getSum() shouldBe 10
            }
        }
    }
})
