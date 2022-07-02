package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoMarketTest {

    @Test
    fun `로또를 수동으로 구매할 수 있다`() {
        val user = User(Money(1000), 1)
        val market = LottoMarket()

        val lottoPaper = market.buyManual(user, listOf(Lotto(1, 2, 3, 4, 5, 6)))

        assertThat(lottoPaper.lottos).hasSize(1)
        assertThat(user.money.value).isEqualTo(0)
    }

    @Test
    fun `돈이 모자라면 로또를 수동으로 구매할 수 없다`() {
        val user = User(Money(0), 1)
        val market = LottoMarket()

        assertThrows<IllegalStateException> { market.buyManual(user, listOf(Lotto(1, 2, 3, 4, 5, 6))) }
    }

    @Test
    fun `로또를 자동으로 구매할 수 있다`() {
        val user = User(Money(1000), 1)
        val market = LottoMarket()

        val lottoPaper = market.buyMaxAutomation(user)

        assertThat(lottoPaper.lottos).hasSize(1)
        assertThat(user.money.value).isEqualTo(0)
    }
}
