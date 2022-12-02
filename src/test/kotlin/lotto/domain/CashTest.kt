package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CashTest {

    @Test
    fun `금액은 음수가 될 수 없다`() {
        assertThrows<IllegalArgumentException> { Cash(-10) }
    }

    @Test
    fun `사용한 만큼 금액을 차감한다`() {
        val cash = Cash(2000)
        assertThat(cash.pay(500).amount).isEqualTo(1500)
    }

    @Test
    fun `금액이 부족하면 예외가 발생한다`() {
        val cash = Cash(1000)
        assertThrows<IllegalArgumentException> { cash.pay(2000) }
    }
}
