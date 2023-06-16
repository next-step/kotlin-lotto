package lottery.domain.lottery

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lottery.domain.lottery.LotteryNumberTest.Companion.LOTTERY_NUMBER_6
import lottery.domain.lottery.LotteryTest.Companion.LOTTERY_1_6

class WinningLotteryTest : FunSpec({

    context("init") {
        test("로또 번호 6개와 보너스번호가 동일할 경우 예외가 발생한다") {
            val lottery = LOTTERY_1_6
            val bonusNumber = LOTTERY_NUMBER_6

            val exception = shouldThrowExactly<IllegalArgumentException> {
                WinningLottery(
                    lottery = lottery,
                    bonusNumber = bonusNumber
                )
            }
            exception.message shouldBe "당첨 번호와 보너스 번호는 동일할 수 없다"
        }
    }
})
