import lotto.LottoTicket

fun interface IssueStrategy {
    fun issue(): List<LottoTicket>
}
