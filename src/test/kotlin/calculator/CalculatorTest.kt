package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class CalculatorTest : StringSpec({
    "빈문자열 일 경우" {
        // given
        val expression = ""

        // when
        val result = Calculator.calculate(expression)

        // then
        result shouldBe 0
    }

    "기본 문자열로 이루어져 있는 경우" {
        forAll(
            row(":2,3", 5),
            row("1:2:3", 6),
            row(",3:1", 4)
        ) { expression, expect ->
            // when
            val result = Calculator.calculate(expression)

            // then
            result shouldBe expect
        }
    }

    "복합 문자열로 이루어져 있는 경우" {
        forAll(
            row("//;\n2,3", 5),
            row("1//,\n2:3", 6),
            row(",3//hi\n1", 4),
            row(",3//hi\n1,4//:\n5", 13),
        ) { expression, expect ->
            // when
            val result = Calculator.calculate(expression)

            // then
            result shouldBe expect
        }
    }

    "구분자 사이에 양수가 아닌 수가 있는 경우" {
        forAll(row("//hi\n2,-3:4"), row("//hi\n2,3:a"), row("//hi\na,3"), row("//hi\n-2,1:0")) {
            // when & then
            shouldThrow<RuntimeException> {
                Calculator.calculate(it)
            }.shouldHaveMessage("피연산자는 양수만 가능합니다")
        }
    }
})
