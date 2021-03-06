package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @Test
    fun `음수를 문자열 인자로 받으면 Money 객체를 생성할 수 없다`() {
        // given
        val input = "-13000"

        // when
        assertThrows<IllegalArgumentException> { Money(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["14000", "14333", "14001", "14999"])
    fun `금액 안에서 살 수 있는 최대 로또 갯수를 반환한다`(budget: String) {
        // given
        val money = Money(budget)

        // when
        val count: Int = money.getAvailableLottoCount()

        // then
        assertThat(count).isEqualTo(14)
    }
}
