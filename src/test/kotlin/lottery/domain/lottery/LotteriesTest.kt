package lottery.domain.lottery

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lottery.domain.Rank
import lottery.domain.lottery.Lotteries.Companion.toLotteries
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_1_6
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_2_7
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_3_8
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_4_9

class LotteriesTest : FunSpec({

    context("compareWinningLottery") {
        test("보유한 모든 로또의 결과를 확인할 수 있다") {
            val lotteries = Lotteries(values = listOf(LOTTERY_1_6, LOTTERY_1_6, LOTTERY_3_8, LOTTERY_4_9))
            val winningLottery = LOTTERY_1_6

            val actual = lotteries.compareWinningLottery(winningLottery)

            actual[Rank.FIRST] shouldBe 2
            actual[Rank.SECOND] shouldBe 0
            actual[Rank.THIRD] shouldBe 1
            actual[Rank.FOURTH] shouldBe 1
        }
    }

    context("toLotteries") {
        test("list를 Lotteries 객체로 반환한다") {
            val actual = listOf(LOTTERY_1_6, LOTTERY_2_7, LOTTERY_3_8).toLotteries()
            actual shouldContainAll listOf(LOTTERY_1_6, LOTTERY_2_7, LOTTERY_3_8)
        }
    }
})
