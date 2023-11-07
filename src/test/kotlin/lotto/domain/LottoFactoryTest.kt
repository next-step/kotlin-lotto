package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1000, 2000, 2200, 3000, 3500, 4000, 5000, 5500])
    fun `로또를 구매하면 1000원 단위로 구매한다`(money: Int) {
        // given
        val expected = money / Lotto.LOTTO_PRICE

        // when
        val lottos = LottoFactory.buyLotto(money)

        // then
        assertThat(lottos.size).isEqualTo(expected)
    }
}
