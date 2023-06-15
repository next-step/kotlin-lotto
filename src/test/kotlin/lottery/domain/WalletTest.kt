package lottery.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.LotteryTest
import lottery.domain.lottery.generator.RandomLotteryGenerator
import java.math.BigDecimal

class WalletTest : FunSpec({

    context("buyLottery") {
        test("로또를 구매할 수 없는 경우 예외가 발생한다.") {
            val wallet = Wallet(money = Money(999))
            val exception =
                shouldThrowExactly<IllegalStateException> { wallet.buyLotteries(RandomLotteryGenerator) }
            exception.message shouldBe "로또를 사기엔 부족한 금액이다"
        }

        test("로또를 구매한다") {
            val wallet = Wallet(money = Money(3_500))
            val actual = wallet.buyLotteries(RandomLotteryGenerator)

            wallet.money shouldBe Money(500)
            actual shouldHaveSize 3
        }
    }

    context("calculateLotteryResult") {
        test("당첨 로또를 받아 로또의 당첨 결과를 반환할 수 있다") {
            val wallet = Wallet(
                money = Money(0),
                lotteries = Lotteries(
                    values = mutableListOf(
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
