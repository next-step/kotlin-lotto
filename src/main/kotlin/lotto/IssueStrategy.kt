import lotto.LottoTickets

fun interface IssueStrategy {
    fun issue(): LottoTickets
}
