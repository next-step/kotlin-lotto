package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import service.LotteryMachine

class LottoMachineTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        val twoLengthList = listOf(Lottery(), Lottery())
        twoLengthList.size shouldBe 2

        val buyAutomaticLotteries = LotteryMachine.buyAutomaticLotteries(5, twoLengthList)

        buyAutomaticLotteries.size shouldBe 7
    }
})
