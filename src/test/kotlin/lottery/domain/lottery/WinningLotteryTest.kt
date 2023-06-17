package lottery.domain.lottery

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_2
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_3
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_4
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_5
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_6
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_7
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_8
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_1_6
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_2_7
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_3_8
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_4_9
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_5_10
import lottery.domain.rank.Rank

class WinningLotteryTest : FunSpec({

    context("init") {
        test("로또 번호 6개와 보너스번호가 동일할 경우 예외가 발생한다") {
            val lottery = LOTTERY_1_6
            val bonusNumber = LOTTERY_NUMBER_6

            val exception = shouldThrowExactly<IllegalArgumentException> {
                WinningLottery(
                    lottery = lottery,
                    bonusNumber = bonusNumber,
                )
            }
            exception.message shouldBe "당첨 번호와 보너스 번호는 동일할 수 없다"
        }

        test("로또 번호 6개와 보너스 번호를 들고 있다") {
            val lottery = LOTTERY_1_6
            val bonusNumber = LOTTERY_NUMBER_7

            val actual = WinningLottery(lottery = LOTTERY_1_6, bonusNumber = bonusNumber)

            actual.bonusNumber shouldBe bonusNumber
            actual.lottery.values shouldContainAll lottery.values
        }
    }

    context("compareLottery") {
        test("로또 등수를 반환한다") {
            forAll(
                row(LOTTERY_1_6, Rank.FIRST),
                row(LOTTERY_2_7, Rank.SECOND),
                row(
                    Lottery(
                        values = listOf(
                            LOTTERY_NUMBER_2,
                            LOTTERY_NUMBER_3,
                            LOTTERY_NUMBER_4,
                            LOTTERY_NUMBER_5,
                            LOTTERY_NUMBER_6,
                            LOTTERY_NUMBER_8,
                        ),
                    ),
                    Rank.THIRD,
                ),
                row(LOTTERY_3_8, Rank.FOURTH),
                row(LOTTERY_4_9, Rank.FIFTH),
                row(LOTTERY_5_10, Rank.NOTHING),
            ) { lottery, expected ->
                val winningLottery = WinningLottery(lottery = LOTTERY_1_6, bonusNumber = LOTTERY_NUMBER_7)
                val actual = winningLottery.rankConfirm(lottery)
                actual shouldBe expected
            }
        }
    }
})
