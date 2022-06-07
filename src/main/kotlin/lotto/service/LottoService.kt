package lotto.service

import lotto.domain.LottoTicketMachine
import lotto.domain.Rank

class LottoService {
    fun getLottoRanks(nums: List<List<Int>>, winNums: List<Int>): List<Rank> {
        return nums.map {
            val issue = LottoTicketMachine.issue(it)
            val winLottoTicket = LottoTicketMachine.issue(winNums)

            Rank.determineLottoTicket(winLottoTicket, issue)
        }
    }

    fun getRevenueRate(investment: Double, ranks: List<Rank>): Double {
        val totalPrizeSum = ranks.sumOf {
            it.prize
        }.toDouble()

        return totalPrizeSum / investment
    }
}
