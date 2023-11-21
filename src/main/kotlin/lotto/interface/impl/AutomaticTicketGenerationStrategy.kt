package lotto.`interface`.impl

import lotto.domain.LottoConstants
import lotto.domain.LottoNumbers
import lotto.domain.LottoTicket
import lotto.`interface`.TicketGenerationStrategy

class AutomaticTicketGenerationStrategy : TicketGenerationStrategy {
    override fun generate(): LottoTicket {
        val numbers = (LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END)
            .shuffled()
            .take(LottoConstants.NUMBERS_PER_TICKET)
            .toList()
        return LottoTicket(LottoNumbers.from(numbers))
    }
}
