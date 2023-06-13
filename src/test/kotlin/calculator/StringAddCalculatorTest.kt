package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    val calculator = StringAddCalculator(DefaultExpressionFactory())

    "null 인 값을 입력하면 0을 반환한다" {
        val input = null
        val result = calculator.add(input)
        result shouldBe 0
    }

    "빈 문자열이 들어왔을 때 0을 반환한다." {
        val input = ""
        val result = calculator.add(input)
        result shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        val input = "1"
        val result = calculator.add(input)
        result shouldBe 1
    }

    "음수를 전달할 경우 RuntimeException 예외가 발생해야 한다." {
        val input = "-1"
        val exception = shouldThrow<RuntimeException> {
            calculator.add(input)
        }
        exception.message shouldBe "음수는 입력할 수 없습니다."
    }

    "분리된 숫자의 합을 반환한다." {
        val input = "1,2:3"
        val result = calculator.add(input)
        result shouldBe 6
    }

    "기본 구분자 외에 커스텀 구분자를 지정할 수 있다." {
        val input = "//;\n1;2;3"
        val result = calculator.add(input)
        result shouldBe 6
    }
})
