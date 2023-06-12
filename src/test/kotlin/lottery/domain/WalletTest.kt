package lottery.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WalletTest : FunSpec({

    context("calculateLotteryResult") {
        test("당첨 로또를 받아 로또의 당첨 통계를 반환할 수 있다") {
            val wallet = Wallet(
                usedMoney = 4_000,
                purchasedLotteries = Lotteries(
                    values = listOf(
                        LotteryTest.LOTTERY_1_6,
                        LotteryTest.LOTTERY_1_6,
                        LotteryTest.LOTTERY_3_8,
                        LotteryTest.LOTTERY_4_9
                    )
                )
            )
            val winningLottery = LotteryTest.LOTTERY_1_6

            val actual = wallet.calculateLotteryResult(winningLottery)
            actual[Rank.FIRST] shouldBe 2
            actual[Rank.SECOND] shouldBe 0
            actual[Rank.THIRD] shouldBe 1
            actual[Rank.FOURTH] shouldBe 1
        }
    }
})
