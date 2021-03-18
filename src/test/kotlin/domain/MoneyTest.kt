package domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class MoneyTest {
    @Test
    fun `돈은 정수 하나로 생성된다`() {
        assertDoesNotThrow { Money(1) }
    }

    @Test
    fun `돈은 0원 이하가 될 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy { Money(0) }
        assertThatIllegalArgumentException().isThrownBy { Money(-1) }
        assertThatIllegalArgumentException().isThrownBy { Money(Int.MIN_VALUE) }
    }
}
