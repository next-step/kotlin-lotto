package lotto.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row

class MoneyTest : FreeSpec({
    "금액은 음수로 생성할 경우 예외를 던진다" {
        forAll(
            row(-5),
        ) { amount ->
            shouldThrow<Exception> { Money(amount) }
        }
    }
})
