package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class MoneyTest {

    @Test
    fun `돈은 0 원보다 크다`() {
        assertDoesNotThrow { Money(1) }
        assertThrows<IllegalArgumentException> { Money(0) }
        assertThrows<IllegalArgumentException> { Money(-1) }
    }
}
