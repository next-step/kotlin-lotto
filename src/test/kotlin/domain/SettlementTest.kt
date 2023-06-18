package domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import mock.MockNumberGenerator

internal class SettlementTest : StringSpec({
    "당첨된 총 금액과 유저가 구입한 비용의 비례로 수익률을 계산한다." {
        listOf(
            setOf(1, 2, 3, 8, 7, 9) to 5,
            setOf(1, 2, 3, 4, 7, 8) to 50,
            setOf(1, 2, 3, 4, 5, 7) to 1500,
            setOf(1, 2, 3, 4, 5, 6) to 2_000_000
        ).forAll { (input, expected) ->
            val winnerNumber = setOf(1, 2, 3, 4, 5, 6)
            val settlement = Settlement(winnerNumber)
            val lottery = Lottery(MockNumberGenerator(input))
            val profit = settlement.getReturnOnInvestment(listOf(lottery), 1_000)
            profit shouldBe expected
        }
    }

    "3개 일치시 5000원, 4개 일치시 5만원, 5개 일치시 1_500_000원, 6개 일치시 2_000_000_000 금액을 부여한다." {
        listOf(
            mapOf(Prize.MATCH_3.matches to 1) to Prize.MATCH_3.value,
            mapOf(Prize.MATCH_4.matches to 1) to Prize.MATCH_4.value,
            mapOf(Prize.MATCH_5.matches to 1) to Prize.MATCH_5.value,
            mapOf(Prize.MATCH_6.matches to 1) to Prize.MATCH_6.value
        ).forAll { (input, expected) ->
            val winnerNumber = setOf(1, 2, 3, 4, 5, 6)
            val settlement = Settlement(winnerNumber)
            val profit = settlement.calculateProfit(input)
            profit shouldBe expected
        }
    }
})
