package lotto.domain

interface IssueStrategy {
    fun issue(): LottoNumbers
}

object RandomIssueStrategy : IssueStrategy {

    private const val RANDOM_MIN_VALUE = LottoNumber.MIN_VALUE
    private const val RANDOM_MAX_VALUE = LottoNumber.MAX_VALUE
    private const val ISSUE_SIZE = LottoNumbers.LOTTO_NUMBER_SIZE

    override fun issue(): LottoNumbers {
        val uniqueNumbers = mutableSetOf<Int>()

        while (uniqueNumbers.size < ISSUE_SIZE) {
            val randomValue = (RANDOM_MIN_VALUE..RANDOM_MAX_VALUE).random()
            uniqueNumbers.add(randomValue)
        }
        return LottoNumbers(uniqueNumbers.map { LottoNumber(it) })
    }
}

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
