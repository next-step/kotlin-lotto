package lotto.domain

object FakeIssueStrategy : IssueStrategy {

    private var issueCount = 0

    override fun issue(): LottoNumbers {
        issueCount++
        return LottoNumbers((issueCount..(issueCount + 5)).map { LottoNumber(it) }.toSet())
    }
}
