package tdd_string_add_calculator

import io.kotest.assertions.throwables.shouldThrow
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

    "숫자 이외의 값은 runtime exception" {
        val express = "a"
        shouldThrow<RuntimeException> {
            Calculator.calculate(express)
        }
    }

    "음수 값은 runtime exception" {
        val express = "-1:2,3"
        shouldThrow<RuntimeException> {
            Calculator.calculate(express)
        }
    }

    "커스텀 계산자를 사용해도 잘 작동한다" {
        val express = "//;\n1;2;3"
        val expected = "6"
        Calculator.calculate(express) shouldBe expected
    }

    "2개 값 더하기" {
        val express = "1,2"
        val expected = "3"
        Calculator.calculate(express) shouldBe expected
    }
    
    "커스텀 계산자로 2개 더하기" {
        val express = "//;\n1;2"
        val expected = "3"
        Calculator.calculate(express) shouldBe expected
    }

    "하나의 숫자 입력시 하나 반환" {
        val express = "1"
        val expected = "1"
        Calculator.calculate(express) shouldBe expected
    }
})
