package stringaddcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ParseTest : DescribeSpec({
    it("계산식을 구분자에 맞춰 split 하여 반환한다.") {
        val expectParse = Parse("3:2", listOf(":")).result

        expectParse shouldBe listOf(3, 2)
    }

    context("구분자가 여러개 일 때") {
        it("계산식을 구분자들에 맞춰 split 하여 반환한다.") {
            val expectParse = Parse("3:2,2", listOf(":", ",")).result

            expectParse shouldBe listOf(3, 2, 2)
        }
    }

    context("구분자를 제외한 것 중에 숫자가 아닌 것이 존재할 때") {
        it("IllegalArgumentException 을 반환한다.") {
            val exception = shouldThrow<IllegalArgumentException> {
                Parse("3;2", listOf(",", ":")).result
            }

            exception.message shouldBe "올바른 계산식이 아닙니다."
        }
    }

    context("계산식에 음수가 포함되어있을 때") {
        it("RuntimeException 을 반환한다.") {
            val exception = shouldThrow<RuntimeException> {
                Parse("3:-2", listOf(",", ":")).result
            }

            exception.message shouldBe "음수는 계산 할 수 없습니다."
        }
    }

    context("계산식에 빈 문자열이 포함되어있을 때") {
        it("0을 반환한다") {
            val expectParse = Parse(":2,2", listOf(":", ",")).result

            expectParse shouldBe listOf(0, 2, 2)
        }
    }

    context("계산식 앞에 커스텀 구분자 식이 있을 때") {
        it("커스텀 구분자 식을 제거하고 split 한 값을 반환한다.") {
            val expectParse = Parse("//&\n:2,2", listOf(":", ",")).result

            expectParse shouldBe listOf(0, 2, 2)
        }
    }
})
