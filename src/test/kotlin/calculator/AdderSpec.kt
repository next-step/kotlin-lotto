package calculator

import calcuator.AddOperand
import calcuator.Adder
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AdderSpec : FunSpec({
    test("주어진 수의 합을 반환한다") {
        val numbers = listOf(1, 1, 0, 13).map { AddOperand.of(it.toString()) }

        val result = Adder.sum(numbers)

        result shouldBe 15
    }

    test("빈 문자열로 합을 구하면 0이 반환된다") {
        val numbers = emptyList<AddOperand>()

        val result = Adder.sum(numbers)

        result shouldBe 0
    }
})
