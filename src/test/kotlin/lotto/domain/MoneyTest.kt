package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class MoneyTest {

    @Test
    fun `money는 1000원 단위만 존재한다`() {
        assertDoesNotThrow { Money(1000) }
    }

    @Test
    fun `money는 1000원 단위만 존재한다 예외`() {
        assertThrows<IllegalArgumentException> { Money(1001) }
    }

    @Test
    fun `money는 음수가 될 수 없다`() {
        assertThrows<IllegalArgumentException> { Money(-1) }
    }

    @Test
    fun `0원은 존재 한다`() {
        assertDoesNotThrow { Money(0) }
    }

    @Test
    fun `나누기 테스트`() {
        assertThat(Money(10000) / Money(1000)).isEqualTo(10.0)
    }

    @Test
    fun `0원 으로 나누는 경우`() {
        assertThrows<IllegalArgumentException> { Money(10000) / Money(0) }
    }
}
