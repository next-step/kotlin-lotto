package com.nextstep.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MoneyTest {
    @Test
    fun `금액이 1000원 미만이면 에러`() {
        assertThrows<IllegalArgumentException> {
            Money(500)
        }
    }

    @Test
    fun `지불할 금액이 부족하다면 에러`() {
        assertThrows<IllegalArgumentException> {
            Money(500).pay(1000)
        }
    }

    @Test
    fun `지불하면 금액을 차감한다`() {
        val money = Money(2000)
        money.pay(1000)

        assertThat(money.money).isEqualTo(1000)
    }
}
