package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import lotto.domain.LottoMachine
import lotto.domain.Money
import java.lang.IllegalArgumentException

class MoneyTest : FreeSpec({
    "입력된 금액이 1000원 미만이면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            LottoMachine().buy(Money(999), null)
        }
    }
})
