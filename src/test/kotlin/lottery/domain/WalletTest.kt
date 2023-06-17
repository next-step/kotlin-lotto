package lottery.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lottery.domain.lottery.Lotteries
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_7
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_1_6
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_2_7
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_4_9
import lottery.domain.lottery.WinningLottery
import lottery.domain.lottery.generator.RandomLotteryGenerator
import lottery.domain.rank.Rank
import java.math.BigDecimal

class WalletTest : FunSpec({

    context("purchaseLottery") {
        test("로또를 구매할 수 없는 경우 예외가 발생한다.") {
            val wallet = Wallet(money = Money(BigDecimal(999)))
            val exception =
                shouldThrowExactly<IllegalStateException> { wallet.purchaseLotteries(RandomLotteryGenerator) }
            exception.message shouldBe "로또를 사기엔 부족한 금액이다"
        }

        test("로또를 구매한다") {
            val wallet = Wallet(money = Money(BigDecimal(3_500)))
            val actual = wallet.purchaseLotteries(RandomLotteryGenerator)

            wallet.money shouldBe Money(value = BigDecimal(500))
            actual shouldHaveSize 3
        }
    }

    context("calculateLotteryResult") {
        test("당첨 로또를 받아 로또의 당첨 결과를 반환할 수 있다") {
            val wallet = Wallet(
                money = Money(BigDecimal.ZERO),
                purchaseLotteries = Lotteries(
                    values = mutableListOf(
                        LOTTERY_1_6,
                        LOTTERY_1_6,
                        LOTTERY_2_7,
                        LOTTERY_4_9
                    )
                )
            )
            val winningLottery = WinningLottery(lottery = LOTTERY_1_6, bonusNumber = LOTTERY_NUMBER_7)

            val actual = wallet.calculateLotteryResult(winLottery = winningLottery)
            actual.statistics[Rank.FIRST] shouldBe 2
            actual.statistics[Rank.SECOND] shouldBe 1
            actual.statistics[Rank.THIRD] shouldBe 0
            actual.statistics[Rank.FOURTH] shouldBe 0
            actual.statistics[Rank.FIFTH] shouldBe 1
            actual.lottoYield.setScale(2) shouldBe BigDecimal(1007501.25)
        }
    }
})
