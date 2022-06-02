package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Winning
import lotto.domain.WinningMatcher

class WinningMatcherTest : FreeSpec({
    "지난주 당첨번호와 입력한 로또번호가" - {
        val pastWinner = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
        val bonus = LottoNumber(10)
        "2개 이하로 일치하면 꽝이다" {
            val lotto = Lotto.of(setOf(1, 2, 7, 8, 9, 10))
            WinningMatcher(pastWinner, bonus).getPlace(lotto) shouldBe Winning.LOSE
        }
        "3개 일치하면 5등이다" {
            val lotto = Lotto.of(setOf(1, 2, 3, 7, 8, 9))
            WinningMatcher(pastWinner, bonus).getPlace(lotto) shouldBe Winning.FIFTH_PLACE
        }
        "4개 일치하면 4등이다" {
            val lotto = Lotto.of(setOf(1, 2, 3, 4, 8, 9))
            WinningMatcher(pastWinner, bonus).getPlace(lotto) shouldBe Winning.FOURTH_PLACE
        }
        "5개 일치하면 3등이다" {
            val lotto = Lotto.of(setOf(1, 2, 3, 4, 5, 9))
            WinningMatcher(pastWinner, bonus).getPlace(lotto) shouldBe Winning.THIRD_PLACE
        }
        "4개 일치하고 보너스 번호가 일치하면 2등이다" {
            val lotto = Lotto.of(setOf(1, 2, 3, 4, 9, 10))
            WinningMatcher(pastWinner, bonus).getPlace(lotto) shouldBe Winning.SECOND_PLACE
        }
        "6개 일치하면 1등이다" {
            val lotto = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
            WinningMatcher(pastWinner, bonus).getPlace(lotto) shouldBe Winning.FIRST_PLACE
        }
    }
})
