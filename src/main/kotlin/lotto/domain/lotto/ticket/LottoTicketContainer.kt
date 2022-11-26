package lotto.domain.lotto.ticket

import lotto.domain.lotto.result.LottoResultMatchCountMap

class LottoTicketContainer(
    private val lottoTicketList: List<LottoTicket>
) : List<LottoTicket> by lottoTicketList {

    init {
        require(lottoTicketList.distinct().size == lottoTicketList.size) {
            "LottoTickets should be all distinct"
        }
    }

    constructor(ticketCount: Int) : this(LottoTicket.randomGenerate(ticketCount)) {
        require(ticketCount > 0) { "Ticket count must be > 0 [$ticketCount]" }
    }

    fun resultCountMap(lottoAnswerTicket: LottoAnswerTicket): LottoResultMatchCountMap =
        LottoResultMatchCountMap(
            lottoTicketList.groupingBy { lottoAnswerTicket.calculateMatchCount(it) }.eachCount()
        )
}
