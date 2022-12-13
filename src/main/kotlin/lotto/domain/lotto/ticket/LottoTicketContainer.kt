package lotto.domain.lotto.ticket

import java.util.stream.Stream
import kotlin.streams.toList

class LottoTicketContainer constructor(
    private val lottoTicketList: List<LottoTicket>
) : List<LottoTicket> by lottoTicketList {

    init {
        require(lottoTicketList.isNotEmpty()) {
            "LottoTickets should not be empty"
        }
    }

    companion object {
        fun havingSizeOf(ticketCount: Int): LottoTicketContainer =
            LottoTicketContainer(randomGenerate(ticketCount))

        private fun randomGenerate(ticketCount: Int): List<LottoTicket> {
            require(ticketCount > 0) {
                "Ticket count should be greater than 0 [$ticketCount]"
            }

            return Stream.generate { LottoTicket.randomGenerate() }
                .distinct()
                .limit(ticketCount.toLong())
                .toList()
        }
    }
}
