package domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class MoneyTest {
    @Test
    fun `돈은 정수 하나로 생성된다`() {
        assertDoesNotThrow { Money(1) }
    }
}
