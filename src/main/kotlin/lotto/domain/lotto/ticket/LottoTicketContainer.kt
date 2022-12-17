package lotto.domain.lotto.ticket

import java.util.stream.Stream
import kotlin.streams.toList

class LottoTicketContainer(
    private val lottoTicketList: List<LottoTicket>
) : List<LottoTicket> by lottoTicketList {

    init {
        require(lottoTicketList.isNotEmpty()) {
            "LottoTickets should not be empty"
        }
    }

    companion object {
        fun havingSizeOf(ticketCount: Int, customLottoTicketList: List<LottoTicket> = emptyList()): LottoTicketContainer {
            val remainingTicketCount = ticketCount - customLottoTicketList.size

            require(remainingTicketCount >= 0) {
                "Ticket count should be greater or equal than custom lotto ticket list " +
                        "[$ticketCount >= ${customLottoTicketList.size}]"
            }

            return LottoTicketContainer(
                if (remainingTicketCount > 0)
                    customLottoTicketList + randomGenerate(remainingTicketCount)
                else
                    customLottoTicketList
            )
        }

        private fun randomGenerate(ticketCount: Int): List<LottoTicket> {
            require(ticketCount > 0) {
                "Ticket count should be greater than 0 [$ticketCount]"
            }

            return Stream.generate { LottoTicket.randomGenerate() }
                .limit(ticketCount.toLong())
                .toList()
        }
    }
}
