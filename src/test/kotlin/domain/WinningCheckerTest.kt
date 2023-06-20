package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import mock.MockNumberGenerator

class WinningCheckerTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        listOf(
            setOf(1, 2, 3, 4, 7, 9) to Prize.FOURTH_PLACE,
            setOf(1, 2, 3, 4, 5, 8) to Prize.THIRD_PLACE,
            setOf(1, 2, 3, 4, 5, 10) to Prize.SECOND_PLACE,
            setOf(1, 2, 3, 4, 5, 6) to Prize.FIRST_PLACE,
        ).forAll { (input, expected) ->
            val testLottery = Lottery(MockNumberGenerator(input))
            val winningNums = setOf(1, 2, 3, 4, 5, 6)
            val prize = WinningFinder(winningNums, 10).getPrizeByMatched(testLottery)

            prize shouldBe expected
        }
    }
})
