package lotto.domain.lotto.price

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows

class LottoCostTest : FunSpec({
    context("LottoCost가 정상적으로 생성된다") {
        withData(
            nameFn = { "cost=${it.first}, price=${it.second}" },
            listOf(
                5000 to 1000,
                10000 to 2000,
                30000 to 4000,
                1000 to 1000
            )
        ) {
            val lottoCost = LottoCost(it.first, LottoTicketPrice(it.second))

            val expectedTicketCount = it.first / it.second
            val expectedTicketCost = it.second * expectedTicketCount

            lottoCost shouldNotBe null
            lottoCost.ticketCount shouldBe expectedTicketCount
            lottoCost.ticketCost shouldBe expectedTicketCost
        }
    }

    context("cost가 0보다 작으면, IllegalArgumentException") {
        withData(
            nameFn = { "cost=${it.first} < 0, price=${it.second}" },
            listOf(
                -1000 to 1200,
                -30000 to 2000,
                -999 to 1000,
                -1 to 1
            )
        ) {
            assertThrows<IllegalArgumentException> {
                LottoCost(it.first, LottoTicketPrice(it.second))
            }
        }
    }
})
