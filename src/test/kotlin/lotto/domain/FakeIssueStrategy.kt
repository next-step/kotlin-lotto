package lotto.domain

object FakeIssueStrategy : IssueStrategy {

    private var startNumber = 0

    override fun issue(): LottoNumbers {
        startNumber++
        return LottoNumbers((startNumber..(startNumber + 5)).map { LottoNumber(it) }.toSet())
    }
}
