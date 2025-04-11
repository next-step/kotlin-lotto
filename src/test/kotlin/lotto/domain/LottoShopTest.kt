package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoShopTest {
    @Test
    fun `purchase success`() {
        val purchaseAmount = 15000
        val tickets = LottoShop().purchase(purchaseAmount, listOf())
        assertThat(tickets.size).isEqualTo(15)
    }

    @Test
    fun `purchase with mutable tickets`() {
        val purchaseAmount = 15000
        val tickets = LottoShop().purchase(
            purchaseAmount, listOf(
                Ticket(listOf(1, 2, 3, 4, 5, 6)),
                Ticket(listOf(1, 2, 3, 4, 5, 6)),
                Ticket(listOf(1, 2, 3, 4, 5, 6))
            )
        )
        assertThat(tickets.size).isEqualTo(15)
    }
}
