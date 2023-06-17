package step1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({
    " ',' 로 구분된 수식이 주어졌을때, Calculator가 올바른 값을 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate("3,3,5") shouldBe 11
    }

    " ':' 로 구분된 숫자들이 수식이 주어졌을때, Calculator가 올바른 값을 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate("3:3:5") shouldBe 11
    }

    " ',' 와 ':' 로 구분된 수식이 주어졌을때, Calculator가 올바른 값을 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate("3,3:5") shouldBe 11
    }

    " customDelimiter 'w' 로 구분된 수식이 주어졌을때, Calculator가 올바른 값을 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate("//w\n3w3w5") shouldBe 11
    }

    " customDelimiter 'k' 로 구분된 수식이 주어졌을때, Calculator가 올바른 값을 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate("//k\n3k3k5") shouldBe 11
    }

    " 하나의 숫자만 포함하는 수식이 주어진 경우, Calculator가 하나의 숫자를 그대로 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate("5") shouldBe 5
    }

    " 수식이 null인 경우, Calculator가 0을 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate(null) shouldBe 0
    }

    " 수식이 0 하나인 경우, Calculator가 0을 반환한다 " {
        val calculator = StringCalculator(SimpleAddExpressionParser())
        calculator.calculate("0") shouldBe 0
    }
})
