package cacluator.domain

import calculator.domain.Expression
import calculator.domain.ExpressionFactory
import calculator.domain.Term
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ExpressionFactoryTest : BehaviorSpec({
    given("null인 문자열이 있다") {
        val input = null
        `when`("주어진 문자열로 Expression을 생성하면") {
            then("\"0\" expression을 반환한다") {
                ExpressionFactory.createExpression(input) shouldBe ExpressionFactory.createExpression("0")
            }
        }
    }
    given("빈 문자열이 있다") {
        val input = ""
        `when`("주어진 문자열로 Expression을 생성하면") {
            then("\"0\" expression을 반환한다") {
                ExpressionFactory.createExpression(input) shouldBe ExpressionFactory.createExpression("0")
            }
        }
    }
    given("유효하지 않은 문자열이 있다") {
        val input = "!!1"
        `when`("주어진 문자열로 Expression을 생성하면") {
            then("예외가 발생한다") {
                shouldThrow<RuntimeException> { ExpressionFactory.createExpression(input) }
            }
        }
    }
    given("파싱 불가능한 문자열이 있다") {
        val input = "1,2:3:"
        `when`("주어진 문자열로 Expression을 생성하면") {
            then("예외가 발생한다") {
                shouldThrow<RuntimeException> { ExpressionFactory.createExpression(input) }
            }
        }
    }
    given("커스텀 구분자가 비어있는 문자열이 있다") {
        val input = "//\n1?2?3?4"
        `when`("주어진 문자열로 Expression을 생성하면") {
            then("예외가 발생한다") {
                shouldThrow<RuntimeException> {
                    ExpressionFactory.createExpression(input)
                }
            }
        }
    }
    given("커스텀 구분자로 구분된 문자열이 있다") {
        val input = "//?\n1?2?3?4"
        `when`("커스텀 구분자를 지정하면") {
            then("커스텀 구분자로 분할후 생성한다") {
                ExpressionFactory.createExpression(input) shouldBe Expression(
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
    given("유효한 문자열이 있다") {
        val input = "1,2:3,4"
        `when`("유효한 식이 들어오면") {
            then("정상적으로 생성된다") {
                ExpressionFactory.createExpression(input) shouldBe Expression(
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
