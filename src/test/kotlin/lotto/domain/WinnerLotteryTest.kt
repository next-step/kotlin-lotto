package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import lotto.domain.lottery.Lottery
import lotto.domain.lottery.LotteryNumber
import lotto.domain.lottery.WinnerLottery
import lotto.domain.test.lotteryNumbers

class WinnerLotteryTest : StringSpec({
    "bonus 값은 1~45 사이의 정수가 가능" {
        (7..45).forEach {
            shouldNotThrowAny {
                WinnerLottery(lotteryNumbers(1, 2, 3, 4, 5, 6), bonus = LotteryNumber(it))
            }
        }
    }

    "bonus 값은 당첨 번호와 중복 될 수 없다" {
        (1..6).forEach {
            val bonus = LotteryNumber(it)
            shouldThrow<IllegalArgumentException> {
                WinnerLottery(lotteryNumbers(1, 2, 3, 4, 5, 6), bonus = bonus)
            }.shouldHaveMessage("bonus 값은 당첨 번호와 중복 될 수 없습니다. bonus : $bonus")
        }
    }

    "당첨 등수 구하기" {
        // given
        val winnerLottery = WinnerLottery(lotteryNumbers(1, 2, 3, 4, 5, 6), bonus = LotteryNumber(7))
        table(
            headers("로또 번호", "expect", "description"),
            row(Lottery(lotteryNumbers(1, 2, 3, 4, 5, 6)), WinnerPrize.FIRST_PRIZE, "1등"),
            row(Lottery(lotteryNumbers(1, 2, 3, 4, 5, 7)), WinnerPrize.SECOND_PRIZE, "2등"),
            row(Lottery(lotteryNumbers(1, 2, 3, 4, 5, 8)), WinnerPrize.THIRD_PRIZE, "3등"),
            row(Lottery(lotteryNumbers(1, 2, 3, 4, 7, 8)), WinnerPrize.FOURTH_PRIZE, "4등")
        ).forAll { lottery, expect, _ ->
            val result = winnerLottery.calculatePrize(lottery)
            result shouldBe expect
        }
    }
})
