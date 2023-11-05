package lotto.domain

class LottoIssuer(
    private val ticketAmount: Amount,
    private val issueStrategy: IssueStrategy
) {

    fun issue(purchaseAmount: Amount): LottoTicket {
        require(purchaseAmount % ticketAmount == 0) {
            "로또 구입 금액은 로또 한 장의 가격의 배수여야 합니다."
        }

        val issueCount = purchaseAmount / ticketAmount
        return LottoTicket(purchaseAmount, List(issueCount) { issueStrategy.issue() })
    }
}
