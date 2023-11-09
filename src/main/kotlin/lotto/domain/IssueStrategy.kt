package lotto.domain;

interface IssueStrategy {
    fun issue(): LottoNumbers
}

object RandomIssueStrategy : IssueStrategy {

    private const val RANDOM_MIN_VALUE = LottoNumber.MIN_VALUE
    private const val RANDOM_MAX_VALUE = LottoNumber.MAX_VALUE
    private const val ISSUE_SIZE = LottoNumbers.LOTTO_NUMBER_SIZE

    private val LOTTO_NUMBERS = (RANDOM_MIN_VALUE..RANDOM_MAX_VALUE).map(::LottoNumber)

    override fun issue(): LottoNumbers = LottoNumbers(extractRandomNumbers().toSet())

    private fun extractRandomNumbers(): List<LottoNumber> =
        LOTTO_NUMBERS.shuffled().subList(0, ISSUE_SIZE)
}
