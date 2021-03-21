package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, Int.MAX_VALUE])
    fun `돈은 정수 하나로 생성된다`(value: Int) {
        assertDoesNotThrow { Money(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, Int.MIN_VALUE])
    fun `돈은 0원 미만이 될 수 없다`(value: Int) {
        assertThatIllegalArgumentException().isThrownBy { Money(value) }
    }

    @Test
    fun `돈은 서로 다른 객체라도, 금액이 같으면 동일하다`() {
        assertThat(Money(1)).isEqualTo(Money(1))
    }

    @Test
    fun `돈은 서로 대소 비교를 할 수 있다`() {
        val other = Money(1000)
        assertThat(Money(999)).isLessThan(other)
        assertThat(Money(1001)).isGreaterThan(other)
    }
}
