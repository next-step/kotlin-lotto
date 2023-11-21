package lotto.presentation.controller.dto

import lotto.domain.LottoTickets

class PurchaseResponse private constructor(val tickets: List<List<Int>>) {

    companion object {
        fun of(tickets: LottoTickets): PurchaseResponse {
            return PurchaseResponse(tickets.tickets.map { it.numbers })
        }
    }
}
