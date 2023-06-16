package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LotteryShopKoTest : StringSpec({

    "구매한 금액에 해당하는 로또 갯수 반환" {
        val lotteryShop = LotteryShop()
        val actualInput = 14000
        lotteryShop.buy(actualInput) shouldBe 14
    }
})
