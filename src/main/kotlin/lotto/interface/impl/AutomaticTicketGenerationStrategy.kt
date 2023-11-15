package lotto.`interface`.impl

import lotto.domain.LottoConstants
import lotto.domain.LottoTicket
import lotto.`interface`.TicketGenerationStrategy

class AutomaticTicketGenerationStrategy : TicketGenerationStrategy {
    override fun generate(): LottoTicket {
        return LottoTicket(
            (LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END)
                .shuffled()
                .take(LottoConstants.NUMBERS_PER_TICKET)
                .sorted()
        )
    }
}
