package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.Winning
import lotto.domain.WinningMatcher

class WinningMatcherTest : FreeSpec({
    "지난주 당첨번호와" - {
        val pastWinner = Lotto.of(setOf(1, 2, 3, 4, 5, 6))

        "3개 일치하면 4등이다" {
            val fourthPlace = Lotto.of(setOf(1, 2, 3, 7, 8, 9))
            WinningMatcher(pastWinner).getPlace(fourthPlace) shouldBe Winning.FOURTH_PLACE
        }
        "4개 일치하면 3등이다" {
            val fourthPlace = Lotto.of(setOf(1, 2, 3, 4, 8, 9))
            WinningMatcher(pastWinner).getPlace(fourthPlace) shouldBe Winning.THIRD_PLACE
        }
        "5개 일치하면 2등이다" {
            val fourthPlace = Lotto.of(setOf(1, 2, 3, 4, 5, 9))
            WinningMatcher(pastWinner).getPlace(fourthPlace) shouldBe Winning.SECOND_PLACE
        }
        "6개 일치하면 1등이다" {
            val fourthPlace = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
            WinningMatcher(pastWinner).getPlace(fourthPlace) shouldBe Winning.FIRST_PLACE
        }
    }
})
