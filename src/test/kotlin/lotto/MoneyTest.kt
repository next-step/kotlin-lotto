package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

internal class MoneyTest : FunSpec({

    test("구매 금액 입력값은 0이상의 정수여야 한다.") {
        shouldThrow<IllegalArgumentException> {
            Money(-1)
        }
    }
})
