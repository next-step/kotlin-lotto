package lotto.domain

class LottoIssuer(
    private val ticketAmount: Amount,
    private val issueStrategy: IssueStrategy
) {

    fun issue(purchaseAmount: Amount): LottoTicket {
        val issueCount = runCatching {
            purchaseAmount.divide(ticketAmount)
        }.onFailure {
            throw IllegalArgumentException("로또 구입 금액은 로또 한 장의 가격의 배수여야 합니다.")
        }.getOrThrow()

        return LottoTicket(purchaseAmount, List(issueCount) { issueStrategy.issue() })
    }
}
