package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryShopTest {

    @Test
    fun `로또 1장의 가격은 1000이다`() {
        val lotteryShop = LotteryShop()
        val actualInput = 1000
        assertThat(lotteryShop.buy(actualInput)).isEqualTo(1000)
    }
}
