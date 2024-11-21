package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OperandsTest : StringSpec({
    "피연산자는 음수를 포함할 수 없다" {
        shouldThrow<RuntimeException> {
            Operands(listOf(-1))
        }
    }

    "피연산자들의 합을 구할 수 있다" {
        forAll(
            row(listOf(), 0),
            row(listOf(1), 1),
            row(listOf(1, 2, 3, 4), 10),
        ) { input, expectedSum ->
            val sut = Operands(input)
            sut.sum() shouldBe expectedSum
        }
    }
})
