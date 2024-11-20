package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({
    "숫자의 범위는 0 이상 1억 이하이다." {
        forAll(
            row(-1),
            row(-10),
            row(-100),
            row(100_000_001),
            row(1_000_000_000),
        ) { amount ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    Number(amount)
                }
            exception.message shouldBe "숫자의 범위는 0 이상 1억 이하입니다."
        }
    }

    "다른 숫자와 덧셈을 할 수 있다." {
        forAll(
            row(1, 2, 3),
            row(10, 2, 12),
            row(45, 54, 99),
            row(300, 7, 307),
            row(999, 888, 1887),
        ) { amountA, amountB, expectedAmount ->
            val numberA = Number(amountA)
            val numberB = Number(amountB)
            val actual = numberA.plus(numberB)
            actual shouldBe Number(expectedAmount)
        }
    }
})
