package lotto

import IssueStrategy

object LottoCreator {

    fun issue(strategy: IssueStrategy): List<LottoTicket> {
        return strategy.issue()
    }
}
