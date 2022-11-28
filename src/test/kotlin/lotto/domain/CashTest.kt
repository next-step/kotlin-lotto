package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class CashTest : StringSpec({
    "금액은 음수가 될 수 없다." {
        shouldThrow<IllegalArgumentException> {
            Cash(-100)
        }
    }

    "금액이 부족하면 결제시 예외 발생한다." {
        shouldThrow<IllegalStateException> {
            Cash(10).play(1000)
        }
    }

    "결제 후 잔액은 차감된다." {
        forAll(
            row(Cash(10), 1, 9),
            row(Cash(9), 4, 5),
            row(Cash(8), 3, 5),
        ) { cash, payment, changes ->
            cash.play(payment).amount shouldBe changes
        }
    }
})
