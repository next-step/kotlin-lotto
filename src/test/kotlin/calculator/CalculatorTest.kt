package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : BehaviorSpec({

    val calculator = Calculator()

    given("계산기에 주어신 표현식이") {

        `when`("정상적인 경우") {
            val expression = Expression.of("1,2,3,4,5")
            then("모든 숫자의 합을 반환 한다.") {
                val result = calculator.plusAll(expression)
                result shouldBe 15
            }
        }

        `when`("빈 문자열인 경우") {
            val expression = Expression.of("")
            then("계산 결과는 0 이다.") {
                val result = calculator.plusAll(expression)
                result shouldBe 0
            }
        }
    }
})
