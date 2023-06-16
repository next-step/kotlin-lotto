package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryShopKoTest : StringSpec({

    "로또 1장의 가격은 1000이다" {
        val lotteryShop = LotteryShop()
        val actualInput = 1000
        lotteryShop.buy(actualInput) shouldBe 1000
    }
})
