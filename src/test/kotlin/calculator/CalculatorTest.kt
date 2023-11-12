package calculator

import caclulator.Calculator
import io.kotest.core.spec.style.StringSpec
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
})