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
import lotto.domain.lottery.WinnerLottery

class WinnerLotteryTest : StringSpec({
    "bonus 값은 1~45 사이의 정수가 가능" {
        (7..45).forEach {
            shouldNotThrowAny {
                WinnerLottery(setOf(1, 2, 3, 4, 5, 6), bonus = it)
            }
        }
    }

    "bonus 값은 1~45 사이의 정수가 아닐때" {
        table(
            headers("보너스 볼"),
            row(0),
            row(46),
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                WinnerLottery(setOf(1, 2, 3, 4, 5, 6), bonus = it)
            }.shouldHaveMessage("bonus 값은 로또의 숫자는 1~45 사이의 정수가 가능합니다. bonus : $it")
        }
    }

    "bonus 값은 당첨 번호와 중복 될 수 없다" {
        (1..6).forEach {
            shouldThrow<IllegalArgumentException> {
                WinnerLottery(setOf(1, 2, 3, 4, 5, 6), bonus = it)
            }.shouldHaveMessage("bonus 값은 당첨 번호와 중복 될 수 없습니다. bonus : $it")
        }
    }

    "당첨 등수 구하기" {
        // given
        val winnerLottery = WinnerLottery(setOf(1, 2, 3, 4, 5, 6), bonus = 7)
        table(
            headers("로또 번호", "expect", "description"),
            row(Lottery(setOf(1, 2, 3, 4, 5, 6)), WinnerPrize.FIRST_PRIZE, "1등"),
            row(Lottery(setOf(1, 2, 3, 4, 5, 7)), WinnerPrize.SECOND_PRIZE, "2등"),
            row(Lottery(setOf(1, 2, 3, 4, 5, 8)), WinnerPrize.THIRD_PRIZE, "3등"),
            row(Lottery(setOf(1, 2, 3, 4, 7, 8)), WinnerPrize.FOURTH_PRIZE, "4등")
        ).forAll { lottery, expect, _ ->
            val result = winnerLottery.calculatePrize(lottery)
            result shouldBe expect
        }
    }
})
