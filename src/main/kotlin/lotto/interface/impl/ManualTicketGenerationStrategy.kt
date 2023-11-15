package lotto.`interface`.impl

import lotto.domain.LottoTicket
import lotto.`interface`.TicketGenerationStrategy

class ManualTicketGenerationStrategy(private val manualNumbers: List<Int>) : TicketGenerationStrategy {
    override fun generate(): LottoTicket {
        return LottoTicket(manualNumbers)
    }
}
