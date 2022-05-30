package lotto

import racing.domain.gamerule.IssueStrategy

object LottoCreator {

    fun issue(count: Int, strategy: IssueStrategy): List<List<Int>> {
        require(count > 0)
        return strategy.issue()
    }
}
