package lotto.domain

import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.Assertions.*

class MoneyTest : StringSpec({

    "금액은 1000원 이상이여야 한다" {
        assertThrows(IllegalArgumentException::class.java) {
            Money(999)
        }
    }

    "금액을 입력하면 구입가능 로또 개수를 반환한다" {
        val money = Money(14000)
        assertEquals(14, money.count())
    }

    "특정 금액만큼 금액을 차감한다" {
        val money = Money(14000)
        val otherMoney = Money(1000)
        assertEquals(13000, money.minus(otherMoney).money)
    }

    "특정 갯수의 로또 금액을 산정" {
        val money = Money.fromCount(14)
        assertEquals(14000, money.money)
    }
})
