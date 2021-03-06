package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MoneyTest {
    @Test
    fun `금액에 해당하는 숫자를 문자열 인자로 주면, Money 객체가 정상적으로 생성된다 `() {
        // given
        val input = "14000"

        // when
        val money: Money = Money(input)

        // then
        assertThat(money).isEqualTo(Money(14000))
    }
}
