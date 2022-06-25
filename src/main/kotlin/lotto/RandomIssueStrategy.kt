import lotto.LottoTicketFactory
import lotto.LottoTickets

class RandomIssueStrategy(val count: Int) : IssueStrategy {
    private val ISSUE_RANGE = 1..(count)

    override fun issue(): LottoTickets {
        val factory = LottoTicketFactory()
        return LottoTickets(ISSUE_RANGE.map { factory.createLottoTicket() })
    }
}
