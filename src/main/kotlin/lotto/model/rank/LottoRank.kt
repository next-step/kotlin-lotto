package lotto.model.rank

import lotto.model.number.LottoNumbers

interface LottoRank {
    fun calculateWinningCounts(
        lottoTickets: List<LottoNumbers>,
        winningNumbers: List<Int>,
    ): Map<Int, Int>
}
