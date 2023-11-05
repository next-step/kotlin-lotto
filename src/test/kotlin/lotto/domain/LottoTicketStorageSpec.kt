package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoTicketStorageSpec : FunSpec({
    test("로또 티켓을 저장한다") {
        val tickets = List(3) {
            LottoTicket(listOf(it, it + 1))
        }

        val result = LottoTicketStorage().save(tickets)

        result.forEachIndexed { index, ticket ->
            ticket.numbers shouldBe tickets[index].numbers
        }
    }

    test("로또 티켓을 조회한다") {
        val tickets = List(5) {
            LottoTicket(listOf(it, it + 1))
        }
        val storage = LottoTicketStorage(tickets.toMutableList())

        val result = storage.getAll()
        result.forEachIndexed { index, ticket ->
            ticket.numbers shouldBe tickets[index].numbers
        }
    }
})
