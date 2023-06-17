package lottery.domain.lottery

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lottery.domain.Money
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_8
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_1_6
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_2_7
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_3_8
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_4_9
import lottery.domain.rank.Rank
import java.math.BigDecimal

class LotteriesTest : FunSpec({

    context("compareWinningLottery") {
        test("보유한 모든 로또의 결과를 확인할 수 있다") {
            val lotteries = Lotteries(values = mutableListOf(LOTTERY_1_6, LOTTERY_1_6, LOTTERY_2_7, LOTTERY_4_9))
            val winningLottery = WinningLottery(lottery = LOTTERY_1_6, bonusNumber = LOTTERY_NUMBER_8)

            val actual = lotteries.compareWinningLottery(winningLottery = winningLottery)

            actual[Rank.FIRST] shouldBe 2
            actual[Rank.SECOND] shouldBe 0
            actual[Rank.THIRD] shouldBe 1
            actual[Rank.FOURTH] shouldBe 0
            actual[Rank.FIFTH] shouldBe 1
        }
    }

    context("cost") {
        test("구매한 로또의 금액을 반환할 수 있다.") {
            val lotteries = Lotteries(values = mutableListOf(LOTTERY_1_6, LOTTERY_1_6, LOTTERY_3_8, LOTTERY_4_9))
            val actual = lotteries.cost()
            true and false
            actual shouldBe Money(value = BigDecimal(4_000))
        }
    }

    context("from") {
        test("숫자 문자로 list로 된 lottery list를 받아 생성한다") {
            val actual = Lotteries.from(
                values = listOf(
                    listOf("1", "2", "3", "4", "5", "6"),
                    listOf("2", "3", "4", "5", "6", "7"),
                ),
            )

            actual.values shouldHaveSize 2
        }
    }
})
