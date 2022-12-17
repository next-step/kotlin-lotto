package lotto.ui

import lotto.WinningTicket

class WinningStats(private val tickets: List<WinningTicket>) : UI {
    override fun draw() {
        println("당첨 통계")
        println("---------")
        this.tickets.sortedBy { it.lottoRank.matchCount }
            .groupBy { it.lottoRank.matchCount }
            .forEach {
                val rank = it.value[0].lottoRank
                val count = it.value.size
                WinningStatItem(rank = rank, count = count).draw()
            }
    }
}
