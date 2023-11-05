package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoAccountantSpec : FunSpec({
    context("로또 총 상금 계산") {
        test("로또 총 상금이 계산된다") {
            val lottoResult = listOf(
                LottoResult(matchedNumberCount = 1, ticketCount =  5),
                LottoResult(matchedNumberCount = 2, ticketCount =  10),
            )
            val prizeInfo = listOf(
                WinningPrize(matchedCount = 1, Amount(1000)),
                WinningPrize(matchedCount = 2, Amount(2000)),
            )

            val result = LottoAccountant.getTotalPrizeAmount(lottoResult, prizeInfo)

            result shouldBe Amount(5 * 1000 + 10 * 2000)
        }
    }

    context("구매 금액으로 티켓 수 계산") {
        test("티켓의 배수 금액으로 티켓 수가 생성된다") {
            forAll(
                row(Amount(1000)),
                row(LottoSpec.PRICE),
            ) { ticketPrice ->
                val count = 3
                val amount = ticketPrice * count

                val result = LottoAccountant.calculateTicketCount(amount, ticketPrice)

                result.value shouldBe count
            }
        }

        test("티켓의 배수 금액이 아닐 경우 티켓 수 생성에 실패한다") {
            val amount = LottoSpec.PRICE + Amount(1)

            shouldThrow<IllegalArgumentException> {
                LottoAccountant.calculateTicketCount(amount)
            }
        }
    }
})
