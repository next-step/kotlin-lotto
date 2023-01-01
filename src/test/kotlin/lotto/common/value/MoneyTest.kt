package lotto.common.value

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.common.value.Money.Companion.toMoney
import java.math.BigDecimal

class MoneyTest : FreeSpec({
    "음수로 돈을 생성할 수 없다" {
        val value = BigDecimal.valueOf(-100)
        shouldThrow<IllegalArgumentException> { value.toMoney() }
    }

    "커스텀 연산자로 정의한" - {
        val base = BigDecimal.valueOf(100)
        val value = BigDecimal.valueOf(50)

        "수량과 더하기 연산을 할 수 있다" {
            val quantity = Quantity(5)
            base.toMoney() * quantity shouldBe BigDecimal.valueOf(500).toMoney()
        }

        "나누기 연산을 할 수 있다" {
            base.toMoney() / value.toMoney() shouldBe BigDecimal.valueOf(2).toMoney()
        }

        "빼기 연산을 할 수 있다" {
            base.toMoney() - value.toMoney() shouldBe BigDecimal.valueOf(50).toMoney()
        }
    }
})
