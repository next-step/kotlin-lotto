import lotto.LottoTicket

class RandomIssueStrategy(val count: Int) : IssueStrategy {
    private val ISSUE_RANGE = 1..(count)

    override fun issue(): List<LottoTicket> {
        return ISSUE_RANGE.map { LottoTicket() }
    }
}
