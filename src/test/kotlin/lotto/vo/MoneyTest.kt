package lotto.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class MoneyTest : StringSpec({

    "금액 객체는 음수를 가질 수 없다." {
        val value = -1

        val throwableAction = {
            Money(value)
        }

        shouldThrow<IllegalArgumentException>(throwableAction)
    }

    "금액 객체는 차액을 가진다." {
        val money = Money(1000)

        val result = money - Money(500)

        result shouldBe Money(500)
    }

    "금액 객체 차액시 금액이 부족한 경우 예외를 발생한다." {
        val money = Money(100)

        val throwableAction = {
            money - Money(101)
        }

        shouldThrow<IllegalArgumentException>(throwableAction)
    }
})
