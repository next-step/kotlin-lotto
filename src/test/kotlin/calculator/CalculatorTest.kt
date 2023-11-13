package calculator

import caclulator.Calculator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.*
import io.kotest.matchers.shouldBe

class CalculatorTest: StringSpec({

    "',' 연산자를 입력 받았을 때 계산 결과 출력" {
        val result = Calculator.calculate("2,2,3")
        result shouldBe 7
    }

    "':' 연산자를 입력 받았을 때 계산 결과 출력" {
        val result = Calculator.calculate("2:2:3")
        result shouldBe 7
    }

    "':', ',' 연산자들을 입력 받았을 때 계산 결과 출력" {
        val result = Calculator.calculate("2,2:3")
        result shouldBe 7
    }

    "커스텀 연산자를 입력 받았을 때 계산 결과 출력" {
        val result = Calculator.calculate("//;\\n1;2;3")
        result shouldBe 6
    }

    "빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다." {
        forAll(
            rows = arrayOf(
                Row2(null, 0),
                Row2("", 0)
            ),
        ) { input, expected ->
            val result = Calculator.calculate(input)
            result shouldBe expected
        }
    }

    "음수를 전달할 경우 RuntimeException 예외가 발생해야 한다." {
        shouldThrow<RuntimeException> {
            Calculator.calculate("-1:2:-3")
        }
    }

})
