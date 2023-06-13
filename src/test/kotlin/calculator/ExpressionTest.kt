package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ExpressionTest : StringSpec({

    "null 인 값을 입력하면 0을 반환한다." {
        val input = null
        val result = Expression(input).numbers
        result shouldBe listOf(0)
    }

    "빈 문자열이 들어왔을 때 0을 반환한다." {
        val input = ""
        val result = Expression(input).numbers
        result shouldBe listOf(0)
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        val input = "1"
        val result = Expression(input).numbers
        result shouldBe listOf(1)
    }

    "음수를 전달할 경우 RuntimeException 예외가 발생해야 한다." {
        val input = "-1"
        val exception = shouldThrow<RuntimeException> {
            Expression(input)
        }
        exception.message shouldBe "음수는 입력할 수 없습니다."
    }

    "문자열을 입력하면 쉼표와 콜론을 기준으로 숫자를 분리한다" {
        val input = "1,2"
        Expression(input).numbers shouldBe listOf(1, 2)
    }

    "기본 구분자 외에 커스텀 구분자를 지정할 수 있다." {
        val input = "//;\n1;2;3"
        val result = Expression(input).numbers
        result shouldBe listOf(1, 2, 3)
    }
})
