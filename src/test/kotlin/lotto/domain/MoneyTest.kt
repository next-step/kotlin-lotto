package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun `대소 비교를 할 수 있다`() {
        assertThat(Money(1000) > Money(500)).isEqualTo(true)
    }

    @Test
    fun `나눗셈을 할 수 있다`() {
        assertThat(Money(1000) / Money(500)).isEqualTo(2)
    }

    @Test
    fun `덧셈을 할 수 있다`() {
        assertThat(Money(500) + Money(500)).isEqualTo(Money(1000))
    }
}
