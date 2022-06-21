import lotto.LottoTicket
import lotto.LottoTicketFactory

class RandomIssueStrategy(val count: Int) : IssueStrategy {
    private val ISSUE_RANGE = 1..(count)

    override fun issue(): List<LottoTicket> {
        val factory = LottoTicketFactory()
        return ISSUE_RANGE.map { factory.createLottoTicket() }
    }
}
