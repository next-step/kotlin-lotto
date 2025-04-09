package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `purchase success`() {
        val purchaseAmount = 15000
        val tickets = LottoShop().purchase(purchaseAmount)
        assertThat(tickets.size).isEqualTo(15)
    }
}
