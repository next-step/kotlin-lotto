package lotto.domain

import lotto.domain.LottoStore.Companion.LOTTO_PRICE
import lotto.vo.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoStoreTest {
    @Test
    @DisplayName("로또 구입 금액을 입력하면 구입 금액만큼 자동 로또가 발급된다")
    fun autoLottoBuyTest() {
        // given
        val money = Money(14000)
        val expected = money / LOTTO_PRICE
        // when
        val lottos = LottoStore().buy(money)
        // then
        assertThat(lottos.size).isEqualTo(expected)
    }

    @Test
    @DisplayName("자동, 수동을 섞어서 로또를 구매할 수 있다")
    fun autoAndManualBuyTest() {
        // given
        val money = Money(14000)
        val manualLottos = listOf(
            Lotto.of(setOf(1, 2, 3, 4, 5, 6)),
            Lotto.of(setOf(1, 2, 3, 4, 5, 6)),
            Lotto.of(setOf(1, 2, 3, 4, 5, 6))
        )
        // when
        val lottos = LottoStore().buy(money, manualLottos)
        // then
        assertThat(lottos).containsAnyElementsOf(manualLottos)
    }

    @Test
    @DisplayName("수동으로 로또를 구매할 수 있다")
    fun manualBuyTest() {
        // given
        val money = Money(3000)
        val manualLottos = listOf(
            Lotto.of(setOf(1, 2, 3, 4, 5, 6)),
            Lotto.of(setOf(1, 2, 3, 4, 5, 6)),
            Lotto.of(setOf(1, 2, 3, 4, 5, 6))
        )
        // when
        val lottos = LottoStore().buy(money, manualLottos)
        // then
        assertThat(lottos).containsExactlyElementsOf(manualLottos)
    }
}
