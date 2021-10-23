package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoneyTest {

    @Test
    fun `돈을 생성할 수 있다`() {
        val money = Money.valueOf(1000)

        assertThat(money).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000])
    fun `돈을 입력하면 구매 가능한 로또 갯수를 출력한다`(givenValue: Int) {
        // given
        val money = Money.valueOf(givenValue)
        val lottoPrice = 1000
        val expected = givenValue / lottoPrice

        // then
        assertThat(money.getLottoCount()).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [100, 500, 900])
    fun `돈에 최소 로또 금액을 입력하지 않으면 예외를 던진다`(givenValue: Int) {
        assertThatCode { Money.valueOf(givenValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
