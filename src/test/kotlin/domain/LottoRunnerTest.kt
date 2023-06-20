package domain

import LotteryMachine
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRunnerTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        LotteryMachine.checkLotteriesWin(listOf(Lottery()), setOf(1, 2, 3), 1)
    }

    "클라이언트의 금액에 따라 로또 장수를 리턴한다" {
        val (purchasedAmount, lotteries) = LotteryMachine.buyLotteries(14_000)
        purchasedAmount shouldBe 14_000
        lotteries.size shouldBe 14
    }
})
