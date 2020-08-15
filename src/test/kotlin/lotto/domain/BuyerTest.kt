package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BuyerTest {
    @Test
    fun `사용자는 로또는 구매금액만큼 살 수 있다`() {
        assertThat(Buyer(3000).purchasedCount).isEqualTo(3)
    }
}
