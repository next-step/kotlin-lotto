package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    fun `머니 객체가 음수를 받았을 때 예외 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            Money(-1)
        }
    }

    @Test
    fun `머니 객체의 더하기연산 테스트`() {
        val sumResultMoney = Money(3) + Money(5)

        val answer = sumResultMoney
        val expect = Money(8)

        assertThat(answer).isEqualTo(expect)
    }
}
