package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import mock.MockNumberGenerator

internal class SettlementTest : StringSpec({
    "당첨된 총 금액과 유저가 구입한 비용의 비례로 수익률을 계산한다." {
        listOf(
            listOf(1, 2, 3, 8, 7, 9) to 5,
            listOf(1, 2, 3, 4, 7, 8) to 50,
            listOf(1, 2, 3, 4, 5, 7) to 1500,
            listOf(1, 2, 3, 4, 5, 6) to 2_000_000
        ).forAll { (input, expected) ->
            val winnerNumber = listOf(1, 2, 3, 4, 5, 6)
            val settlement = Settlement(winnerNumber)
            val lottery = Lottery(MockNumberGenerator(input))
            val profit = settlement.getReturnOnInvestment(listOf(lottery), 1_000)
            profit shouldBe expected
        }
    }

    "3개 일치시 5000원, 4개 일치시 5만원, 5개 일치시 1_500_000원, 6개 일치시 2_000_000_000 금액을 부여한다." {
        listOf(
            mapOf(Prize.FOURTH_PLACE to 1) to Prize.FOURTH_PLACE.prizeMoney,
            mapOf(Prize.THIRD_PLACE to 1) to Prize.THIRD_PLACE.prizeMoney,
            mapOf(Prize.SECOND_PLACE to 1) to Prize.SECOND_PLACE.prizeMoney,
            mapOf(Prize.FIRST_PLACE to 1) to Prize.FIRST_PLACE.prizeMoney
        ).forAll { (input, expected) ->
            val winnerNumber = listOf(1, 2, 3, 4, 5, 6)
            val settlement = Settlement(winnerNumber)
            val profit = settlement.calculateProfit(input)
            profit shouldBe expected
        }
    }
})
