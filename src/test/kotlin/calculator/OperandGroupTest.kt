package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class OperandGroupTest : FunSpec({
    context("합 연산") {
        test("그룹에 속한 Operand 들의 합을 구할 수 있다.") {
            // given
            val operandGroup = OperandGroup(
                operands = listOf(
                    Operand.from("3"),
                    Operand.from("5"),
                    Operand.from("8"),
                )
            )
            // when
            val actaul = operandGroup.sum()
            // then
            actaul shouldBe 16
        }
    }
})
