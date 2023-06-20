package domain

import LotteryMachine
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        val twoLengthList = mutableListOf(Lottery(), Lottery())
        twoLengthList.size shouldBe 2

        LotteryMachine.buyAutomaticLotteries(5, twoLengthList)

        twoLengthList.size shouldBe 7
    }

    "클라이언트의 금액에 따라 로또 장수를 리턴한다" {
        LotteryMachine.checkManualSize(14_000, 14)

        shouldThrow<IllegalArgumentException> {
            LotteryMachine.checkManualSize(14_000, 15) shouldBe false
        }.message shouldBe "${15}수동 구매 수량은 ${14_000 / 1000}보다 작아야 합니다."
    }
})
