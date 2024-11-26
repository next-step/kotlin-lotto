package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.LotteryTicketMachine.Companion.TICKET_PRICE

class ReturnsTest : StringSpec({
    "총 당첨 금액과 총 비용을 받아 수익률을 구할 수 있다(기본 소수점 둘째자리, 내림)" {
        val totalWinningAmount = Money(5000)
        val totalCost = Money(14000)

        val result = RateOfReturn(totalWinningAmount = totalWinningAmount, totalCost = totalCost)

        result.toDouble() shouldBe 0.35
    }

    "총 비용은 로또 티켓 1장 가격보다 같거나 커야 한다" {
        val totalWinningAmount = Money(5000)
        val totalCost = TICKET_PRICE - Money(1)

        shouldThrow<IllegalArgumentException> {
            RateOfReturn(totalWinningAmount = totalWinningAmount, totalCost = totalCost)
        }
    }

    "수익률에서 소수점 자리를 정해서 보여줄 수 있다" {
        val totalWinningAmount = Money(1000)
        val totalCost = Money(9000)

        val result = RateOfReturn(totalWinningAmount = totalWinningAmount, totalCost = totalCost)

        forAll(
            row(0, 0),
            row(1, 0.1),
            row(2, 0.11),
            row(3, 0.111),
            row(4, 0.1111),
        ) { scale, expected ->
            result.toDouble(scale) shouldBe expected
        }
    }
})
