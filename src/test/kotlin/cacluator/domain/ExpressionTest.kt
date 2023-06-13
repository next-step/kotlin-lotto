package cacluator.domain

import calculator.domain.ExpressionFactory
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : BehaviorSpec({
    given("getSum 메소드") {
        `when`("유효한 식에 대해") {
            then("합계를 반환한다") {
                val expression = ExpressionFactory.createExpression("1,2:3,4")
                expression.getSum() shouldBe 10
            }
        }
    }
})
