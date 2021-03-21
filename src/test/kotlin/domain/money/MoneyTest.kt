package domain.money

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoneyTest {
    @ParameterizedTest
    @ValueSource(longs = [0, 1, Long.MAX_VALUE])
    fun `돈은 정수 하나로 생성된다`(value: Long) {
        assertDoesNotThrow { Money(value) }
    }

    @ParameterizedTest
    @ValueSource(longs = [-1, Long.MIN_VALUE])
    fun `돈은 0원 미만이 될 수 없다`(value: Long) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { Money(value) }
    }

    @Test
    fun `돈은 서로 다른 객체라도, 금액이 같으면 동일하다`() {
        Assertions.assertThat(Money(1)).isEqualTo(Money(1))
    }

    @Test
    fun `돈은 서로 대소 비교를 할 수 있다`() {
        val other = Money(1000)
        Assertions.assertThat(Money(999)).isLessThan(other)
        Assertions.assertThat(Money(1001)).isGreaterThan(other)
    }
}
