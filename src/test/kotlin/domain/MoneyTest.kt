package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoneyTest {
    @Test
    fun `돈은 정수 하나로 생성된다`() {
        assertDoesNotThrow { Money(1) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, Int.MIN_VALUE])
    fun `돈은 0원 이하가 될 수 없다`(value: Int) {
        assertThatIllegalArgumentException().isThrownBy { Money(value) }
    }

    @Test
    fun `돈은 서로 다른 객체라도, 금액이 같으면 동일하다`() {
        assertThat(Money(1)).isEqualTo(Money(1))
    }
}
