package lotto.common.value

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import lotto.common.value.Money.Companion.toMoney
import java.math.BigDecimal

class MoneyTest : FreeSpec({
    "음수로 돈을 생성할 수 없다" {
        val value = BigDecimal.valueOf(-100)
        shouldThrow<IllegalArgumentException> { value.toMoney() }
    }
})
