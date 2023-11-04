package tdd_string_add_calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "문자열 안의 값을 ,을 사용하여 덧셈한다." {
        val express = "1,2,3"
        val expected = "6"
        Calculator.calculate(express) shouldBe expected
    }

    "문자열 안의 값을 :을 사용하여 덧셈한다." {
        val express = "1:2:3"
        val expected = "6"
        Calculator.calculate(express) shouldBe expected
    }

    "문자열 안의 값을 ,과 :을 같이 사용하여 덧셈한다." {
        val express = "1:2,3"
        val expected = "6"
        Calculator.calculate(express) shouldBe expected
    }

    "빈 문자열은 0을 리턴한다" {
        val express = ""
        val expected = "0"
        Calculator.calculate(express) shouldBe expected
    }
})

