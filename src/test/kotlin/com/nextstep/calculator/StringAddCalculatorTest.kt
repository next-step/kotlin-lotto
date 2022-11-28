package com.nextstep.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
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

    "//와 \n 문자 사이에 커스텀 연산자를 받을 수 있다" {
        calculator.calculate("//;\n1;2;3") shouldBe 6
    }

    "숫자 이외의 값 혹은 음수를 전달하면 throw RuntimeException" {
        forAll(
            row("-1"),
            row("1,-1,6"),
            row("-1,;,3"),
            row("//;\n1;3a5")
        ) { expression ->
            shouldThrow<IllegalArgumentException> { calculator.calculate(expression) }
        }
    }
})
