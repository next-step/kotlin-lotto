package dmain

import domain.Expression
import domain.ExpressionFactory
import domain.Term
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionFactoryTest : BehaviorSpec({
    given("createExpression에서") {
        `when`("null이 들어오면") {
            then("\"0\" expression을 반환한다") {
                ExpressionFactory.createExpression(null) shouldBe ExpressionFactory.createExpression("0")
            }
        }

        `when`("빈문자열이 들어오면") {
            then("\"0\" expression을 반환한다") {
                ExpressionFactory.createExpression("") shouldBe ExpressionFactory.createExpression("0")
            }
        }

        `when`("유효하지 않은 문자열이 들어오면") {
            then("예외가 발생한다") {
                shouldThrow<RuntimeException> { ExpressionFactory.createExpression("!!1") }
            }
        }

        `when`("파싱불가능한 식이 들어오면") {
            then("예외가 발생한다") {
                shouldThrow<RuntimeException> { ExpressionFactory.createExpression("1,2:3:") }
            }
        }

        `when`("유효한 식이 들어오면") {
            then("정상적으로 생성된다") {
                ExpressionFactory.createExpression("1,2:3,4") shouldBe Expression(
                    listOf(
                        Term("1"),
                        Term("2"),
                        Term("3"),
                        Term("4")
                    )
                )
            }
        }
    }
})
