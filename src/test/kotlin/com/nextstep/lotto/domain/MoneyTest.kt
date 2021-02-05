package com.nextstep.lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MoneyTest {
    @Test
    fun `금액이 1000원 미만이면 에러`() {
        assertThrows<IllegalArgumentException> {
            Money(500)
        }
    }
}
