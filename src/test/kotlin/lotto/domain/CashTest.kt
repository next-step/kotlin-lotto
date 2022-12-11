package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

/**
 * @see Cash
 */
class CashTest : FunSpec({

    context("Cash") {
        val cash = Cash(1000)

        test("buyTickets") {
            val (restCash, tickets) = cash.buyTickets()

            restCash shouldBe Cash(0)
            tickets.getTicketCount() shouldBe 1
        }

        test("subtract") {
            cash.subtract(cash) shouldBe Cash(0)
        }

        test("divide") {
            cash.divide(cash) shouldBe 1
        }
    }
})
