package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import mock.MockNumberGenerator

class WinningCheckerTest : StringSpec({
    "로또 번호에 맞춰서 Prize가 당첨 금액을 반환한다." {
        listOf(
            setOf(40, 41, 42, 43, 44, 55) to 0,
            setOf(1, 2, 3, 4, 7, 9) to Prize.FOURTH_PLACE.prizeMoney,
            setOf(1, 2, 3, 4, 5, 8) to Prize.THIRD_PLACE.prizeMoney,
            setOf(1, 2, 3, 4, 5, 10) to Prize.SECOND_PLACE.prizeMoney,
            setOf(1, 2, 3, 4, 5, 6) to Prize.FIRST_PLACE.prizeMoney,
        ).forAll { (input, expected) ->
            val testLottery = Lottery(MockNumberGenerator(input))
            val winningNums = setOf(1, 2, 3, 4, 5, 6)
            val prize = WinningFinder(winningNums, 10).getPrizeMoneyByMatched(testLottery)

            prize shouldBe expected
        }
    }
})
