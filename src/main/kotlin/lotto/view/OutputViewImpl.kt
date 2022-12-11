package lotto.view

import lotto.domain.LottoRewards
import lotto.domain.LottoUsedTickets

object OutputViewImpl {

    fun displayTicketCount(ticketCount: Int) {
        println("${ticketCount}장 구매하였습니다.")
    }

    fun displayTickets(usedTickets: LottoUsedTickets) {
        println(usedTickets.toString())
    }

    fun displayRewards(rewards: LottoRewards) {
        println("당첨 통계")
        println(rewards.toString())
    }

    fun displayProfitRate(profitRate: Int) {
        println("총 수익률은 ${profitRate}입니다. (기준: 1)")
    }
}
