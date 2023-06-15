package lotto.workflow

import lotto.dto.LottoResult
import lotto.entity.Lotto
import lotto.entity.Rank
import lotto.entity.WinningNumber
import lotto.util.LOTTO_PRICE

class RankLotto(
    private val winningNumber: WinningNumber,
) {
    operator fun invoke(lottoTickets: List<Lotto>): LottoResult {
        val rankToInt = getRankToInt(lottoTickets)
        val totalPrize = calculateTotalPrize(rankToInt)
        return LottoResult(rankToInt, totalPrize, lottoTickets.size * LOTTO_PRICE)
    }

    private fun getRankToInt(lottoTickets: List<Lotto>): Map<Rank, Int> {
        val rankToInt = mutableMapOf<Rank, Int>()
        lottoTickets.forEach { rankToInt.getOrPut(winningNumber.howManyNumberMatches(it)) { 1 } }
        return rankToInt
    }

    private fun calculateTotalPrize(rankToInt: Map<Rank, Int>): Long {
        var totalPrize = 0L
        rankToInt.forEach { (rank, number) -> totalPrize += rank.prize * number }
        return totalPrize
    }
}
