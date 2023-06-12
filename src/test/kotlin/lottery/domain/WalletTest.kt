package lottery.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.LotteryTest
import java.math.BigDecimal

class WalletTest : FunSpec({

    context("calculateLotteryResult") {
        test("당첨 로또를 받아 로또의 당첨 결과를 반환할 수 있다") {
            val wallet = Wallet(
                usedMoney = BigDecimal(4_000),
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
            actual.statistics[Rank.FIRST] shouldBe 2
            actual.statistics[Rank.SECOND] shouldBe 0
            actual.statistics[Rank.THIRD] shouldBe 1
            actual.statistics[Rank.FOURTH] shouldBe 1
            actual.lottoYield.setScale(2) shouldBe BigDecimal(1_000_013.75)
        }
    }
})
