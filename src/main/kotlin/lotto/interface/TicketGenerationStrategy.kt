package lotto.`interface`

import lotto.domain.LottoTicket

interface TicketGenerationStrategy {
    fun generate(): LottoTicket
}
