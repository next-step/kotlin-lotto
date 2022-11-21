package lotto.dto

import lotto.domain.LottoTicketBulk

class LottoTicketBulkDto(val tickets: List<Set<Int>>) {
    constructor(lottoTicketBulk: LottoTicketBulk) : this(
        lottoTicketBulk.lottoTickets.map {
            it.lottoNumbers.map { it.value }
                .toSet()
        })
}
