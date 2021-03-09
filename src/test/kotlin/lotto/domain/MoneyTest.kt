package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test
    fun `14000원을 주면 로또 14장을 살 수 있다`() {
        assertThat(Money(14000).requestLottoPurchaseCount()).isEqualTo(14)
    }

    @Test
    fun `1000원으로 로또를 1장 구입한다`() {
        assertThat(Money(1000).requestBuyLotto(1).size).isEqualTo(1)
    }
}
