package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class MoneyTest : StringSpec({

    "금액을 받아 Money 인스턴스를 생성한다" {
        val amount = 1000

        val instance = Money(amount)

        instance.amount shouldBe amount
    }

    "금액에 음수를 제공하면 에러가 발생한다" {
        val amount = -1

        shouldThrow<IllegalArgumentException> {
            Money(amount)
        }
    }
})
