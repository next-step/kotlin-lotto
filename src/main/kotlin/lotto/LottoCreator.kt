package lotto

import IssueStrategy

object LottoCreator {

    fun issue(strategy: IssueStrategy): List<List<Int>> {
        return strategy.issue()
    }
}
