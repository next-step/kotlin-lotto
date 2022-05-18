package stringaddcalculator.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class AdderSpecs : DescribeSpec({

    describe("덧셈기는") {
        context("피연산자들이 주어지면") {
            val operands = listOf(
                Operand(1),
                Operand(2),
                Operand(3)
            )
            it("모든 피연산자를 더한 값을 반환할 수 있다") {
                Adder().add(operands) shouldBe 6
            }
        }
        context("주어진 피연산자들이 비어있다면") {
            val operands = emptyList<Operand>()
            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    Adder().add(operands)
                }
            }
        }
    }
})
