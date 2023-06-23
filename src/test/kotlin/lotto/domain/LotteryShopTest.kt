package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LotteryShopTest {
    @Test
    internal fun `14000원을 입력하면 14장이 구매된다`() {
        LotteryShop.buy(14000) shouldBe 14
    }

    @Test
    internal fun `2장을 발급하면 로또 두장이 발급된다`() {
        LotteryShop.getTickets(2).tickets.size shouldBe 2
    }
}
