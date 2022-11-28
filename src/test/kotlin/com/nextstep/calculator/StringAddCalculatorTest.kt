package com.nextstep.calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : StringSpec({
    val calculator = StringAddCalculator()

    "빈 문자열 또는 null을 입력할 경우 0을 반환한다" {
        calculator.calculate(null) shouldBe 0
        calculator.calculate(" ") shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" {
        calculator.calculate("5") shouldBe 5
    }

    "연산자와 숫자를 파싱한다" {
        calculator.calculate("1,3") shouldBe 4
    }
})
