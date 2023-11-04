package calculator

import calcuator.AddOperand
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class AddOperandSpec : FunSpec({
    test("문자열을 덧셈 피연산자로 변환한다") {
        forAll(
            row("0", 0),
            row("1", 1),
        ) { stringNumber, expect ->

            val result = AddOperand.of(stringNumber)

            result.value shouldBe expect
        }
    }

    test("숫자 이외의 값이 들어오는 경우 피연산자 생성에 실패한다") {
        forAll(
            row(""),
            row("  "),
            row("!")
        ) { stringValue ->

            shouldThrow<IllegalArgumentException> {
                AddOperand.of(stringValue)
            }
        }
    }

    test("음수가 경우 피연산자 생성에 실패한다") {
        val stringValue = "-1"

        shouldThrow<IllegalArgumentException> {
            AddOperand.of(stringValue)
        }
    }
})
