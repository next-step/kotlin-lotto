package lotto.domain;

interface IssueStrategy {
    fun issue(): LottoNumbers
}

object RandomIssueStrategy : IssueStrategy {

    private const val RANDOM_MIN_VALUE = LottoNumber.MIN_VALUE
    private const val RANDOM_MAX_VALUE = LottoNumber.MAX_VALUE
    private const val ISSUE_SIZE = LottoNumbers.LOTTO_NUMBER_SIZE

    private val RANDOM_RANGE = (RANDOM_MIN_VALUE..RANDOM_MAX_VALUE)

    override fun issue(): LottoNumbers {
        val uniqueNumbers = mutableSetOf<Int>()

        while (uniqueNumbers.size < ISSUE_SIZE) {
            val randomValue = RANDOM_RANGE.random()
            uniqueNumbers.add(randomValue)
        }
        return LottoNumbers(uniqueNumbers.map { LottoNumber(it) }.toSet())
    }
}
