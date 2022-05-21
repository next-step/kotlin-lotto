package stringaddcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : DescribeSpec({
    describe("parse") {
        it(": 구분자를 기준으로 계산에 필요한 식으로 변경한다.") {
            val expression = Expression("1:2:3")

            expression.parse()

            expression.operands shouldBe listOf(1,2,3)
        }

        it(", 구분자를 기준으로 계산에 필요한 식으로 변경한다.") {
            val expression = Expression("1,4")

            expression.parse()

            expression.operands shouldBe listOf(1,4)
        }

        it("커스텀 구분자를 기준으로 계산에 필요한 식으로 변경한다.") {
            val expression = Expression("//&\n1&4")

            expression.parse()

            expression.operands shouldBe listOf(1,4)
        }

        it("커스텀 구분자와 기본 구분자를 기준으로 계산에 필요한 식으로 변경한다.") {
            val expression = Expression("//&\n1&4:2")

            expression.parse()

            expression.operands shouldBe listOf(1,4,2)
        }

        context("잘못된 계산식 일 때") {
            it("IllegalArgumentException 이 발생한다.") {
                val expression = Expression("4:,2")

                val exception = shouldThrow<IllegalArgumentException> { expression.parse() }

                exception.message shouldBe "올바른 계산식이 아닙니다."
            }
        }

        context("계산식에 음수가 들어갔을 때") {
            it("IllegalArgumentException 이 발생한다.") {
                val expression = Expression("4:-1")

                val exception = shouldThrow<IllegalArgumentException> { expression.parse() }

                exception.message shouldBe "음수는 계산 할 수 없습니다."
            }
        }
    }
})