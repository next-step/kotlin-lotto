package lotto.domain

class LottoIssuer(
    private val ticketAmount: Amount,
    private val issueStrategy: IssueStrategy
) {

    fun issue(purchaseAmount: Amount, manualLottoNumbers: List<LottoNumbers> = emptyList()): LottoTicket {
        val totalIssueCount = runCatching {
            purchaseAmount.divide(ticketAmount)
        }.onFailure {
            throw IllegalArgumentException("로또 구입 금액은 로또 한 장의 가격의 배수여야 합니다.")
        }.getOrThrow()

        val manualIssueCount = manualLottoNumbers.size
        val autoIssueCount = totalIssueCount - manualIssueCount

        require(autoIssueCount >= 0) { "수동으로 구매할 로또 수가 전체 구매 수를 초과합니다." }

        return LottoTicket(purchaseAmount, List(autoIssueCount) { issueStrategy.issue() } + manualLottoNumbers)
    }
}
