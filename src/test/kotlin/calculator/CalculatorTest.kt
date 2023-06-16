package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "계산기는 표현식에 포함된 모든 숫자의 합을 반환 한다." {
        // given
        val expression = Expression.of("1,2,3,4,5")
        val calculator = Calculator()

        // when
        val result = calculator.plusAll(expression)

        // then
        result shouldBe 15
    }
})
