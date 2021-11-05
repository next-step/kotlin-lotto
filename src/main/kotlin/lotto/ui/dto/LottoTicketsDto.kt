package lotto.ui.dto

import lotto.domain.LottoNumbers
import lotto.domain.LottoTickets

data class LottoTicketsDto(val tickets: List<LottoTicketDto>) {
    constructor(tickets: LottoTickets): this(tickets.tickets.map { LottoTicketDto(it) })
}

data class LottoTicketDto(val lottoNumbers: List<Int>) {
    constructor(numbers: LottoNumbers): this(numbers.numbers.map { it.value }.sorted())
}
