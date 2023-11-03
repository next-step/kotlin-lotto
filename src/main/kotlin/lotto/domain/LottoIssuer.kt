package lotto.domain

interface IssueStrategy {
    fun issue(): LottoNumbers
}

object RandomIssueStrategy : IssueStrategy {

    private const val RANDOM_MIN_VALUE = LottoNumber.MIN_VALUE
    private const val RANDOM_MAX_VALUE = LottoNumber.MAX_VALUE
    private const val ISSUE_SIZE = LottoNumbers.LOTTO_NUMBER_SIZE

    override fun issue(): LottoNumbers = List(ISSUE_SIZE) {
        LottoNumber((RANDOM_MIN_VALUE..RANDOM_MAX_VALUE).random())
    }.let { LottoNumbers(it) }
}

class LottoIssuer(
    private val ticketAmount: Amount,
    private val issueStrategy: IssueStrategy
) {

    fun issue(paymentAmount: Amount): List<LottoNumbers> {
        require(paymentAmount % ticketAmount == 0) {
            "로또 구입 금액은 로또 한 장의 가격의 배수여야 합니다."
        }

        val issueCount = paymentAmount / ticketAmount
        return List(issueCount) { issueStrategy.issue() }
    }
}
