package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningResultTest : StringSpec({
    "당첨 결과는 일치하는 번호 숫자를 받아 찾을 수 있다" {
        forAll(
            row(0, WinningResult.LOSE),
            row(1, WinningResult.LOSE),
            row(2, WinningResult.LOSE),
            row(3, WinningResult.FIFTH),
            row(4, WinningResult.FOURTH),
            row(5, WinningResult.THIRD),
            row(6, WinningResult.FIRST),
        ) { countOfMatch, expectedResult ->
            WinningResult.valueOf(countOfMatch) shouldBe expectedResult
        }
    }

    "일치하는 로또 번호 숫자와 matchBonus 가 true 일 때를 포함하여 당쳠 겱과를 찾을 수 있다." {
        forAll(
            row(0, WinningResult.LOSE),
            row(1, WinningResult.LOSE),
            row(2, WinningResult.LOSE),
            row(3, WinningResult.FIFTH),
            row(4, WinningResult.FOURTH),
            row(5, WinningResult.SECOND),
            row(6, WinningResult.FIRST),
        ) { countOfMatch, expectedResult ->
            WinningResult.valueOf(countOfMatch = countOfMatch, matchBonus = true) shouldBe expectedResult
        }
    }
})
