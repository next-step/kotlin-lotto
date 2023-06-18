package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LotteryShopTest{
    @Test
    internal fun `14000원을 입력하면 14장이 구매된다`() {
        LotteryShop.buy(14000) shouldBe 14
    }
}