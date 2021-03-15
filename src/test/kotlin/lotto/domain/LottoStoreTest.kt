package lotto.domain

import lotto.domain.LottoStore.Companion.LOTTO_PRICE
import lotto.vo.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoStoreTest {
    @Test
    @DisplayName("로또 구입 금액을 입력하면 구입 금액만큼 로또가 발급된다")
    fun inputMoneyTest() {
        // given
        val money = Money(14000)
        val expected = money / LOTTO_PRICE
        // when
        val lottos = LottoStore().buy(money)
        // then
        assertThat(lottos.size).isEqualTo(expected)
    }
}
