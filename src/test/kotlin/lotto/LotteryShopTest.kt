package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryShopTest {

    @Test
    fun `구매한 금액에 해당하는 로또 갯수 반환`() {
        val lotteryShop = LotteryShop()
        val actualInput = 14000
        val userLottery = lotteryShop.buy(actualInput)
        assertThat(userLottery.lotteryCount).isEqualTo(14)
    }
}
