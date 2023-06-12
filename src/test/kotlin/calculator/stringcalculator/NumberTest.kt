package calculator.stringcalculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NumberTest : FunSpec({

    test("유효한 숫자를 전달하면 정상적으로 생성된다") {
        (0..3).forEach {
            val actual = PositiveNumber(it)

            actual.value shouldBe it
        }
    }

    test("유효하지 않은 숫자를 전달하면 예외를 던진다.") {
        (-2..-1).forEach {
            shouldThrow<RuntimeException> { PositiveNumber(it) }
        }
    }

    test("유효한 문자를 전달하면 정상적으로 생성된다.") {
        listOf("0", "1", "2", "3").forEach {
            val actual = PositiveNumber.from(it)

            actual.value shouldBe it.toInt()
        }
    }

    test("유효하지 않은 문자를 전달하면 예외를 던진다.") {
        listOf("a", "number", "", " ", "   ", "-1", "-2").forEach {
            shouldThrow<RuntimeException> { PositiveNumber.from(it) }
        }
    }
})
