package lottery

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lottery.controller.LotteryGame

class LotteryGameTest : StringSpec({
    "로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다." {
        val lotteryGame = LotteryGame()
        val purchaseLotteries = lotteryGame.purchaseAutoLotteries(14000)
        purchaseLotteries.lotteries.size shouldBe 14
    }
})
