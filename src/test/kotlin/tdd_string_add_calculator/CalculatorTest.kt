package tdd_string_add_calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({
    context("문자열 덧셈을 수행한다. withData 사용") {
        val express = listOf("1,2,3", "1:2:3", "1:2,3")
        withData(
            express
        ) { a ->
            Calculator.calculate(a) shouldBe "6"
        }
    }
    context(" 문자열 덧셈을 수행한다. forAll을 사용") {
        forAll(
            row("1,2,3", "6"),
            row("2:3:4", "9"),
            row("1:2,4", "7"),
        ) { express, expected ->
            Calculator.calculate(express) shouldBe expected
        }
    }

    context("빈 문자열은 0을 리턴한다") {
        val express = ""
        val expected = "0"
        Calculator.calculate(express) shouldBe expected
    }

    context("숫자 이외의 값, 음수는 IllegalStateException") {
        val express = listOf("a", "-1:2,3")
        withData(express) { express ->
            shouldThrow<IllegalStateException> {
                Calculator.calculate(express)
            }
        }
    }

    context("커스텀 계산자를 사용해도 잘 작동한다") {
        val express = "//;\n1;2;3"
        val expected = "6"
        Calculator.calculate(express) shouldBe expected
    }

    context("2개 값 더하기") {
        val express = "1,2"
        val expected = "3"
        Calculator.calculate(express) shouldBe expected
    }

    context("커스텀 계산자로 2개 더하기") {
        val express = "//;\n1;2"
        val expected = "3"
        Calculator.calculate(express) shouldBe expected
    }

    context("하나의 숫자 입력시 하나 반환") {
        val express = "1"
        val expected = "1"
        Calculator.calculate(express) shouldBe expected
    }

    context("null 입력시에 0 반환") {
        val express = null
        val expected = "0"
        Calculator.calculate(express) shouldBe expected
    }
})
