package lotto.model.rank

import lotto.model.number.LottoNumbers

class LottoWinningRank : LottoRank {
    override fun calculateWinningCounts(
        lottoTickets: List<LottoNumbers>,
        winningNumbers: List<Int>,
    ): Map<Int, Int> {
        return lottoTickets.groupingBy { lottoNumbers ->
            val winningCounts = matchWinningLottoNumbersCount(lottoNumbers, winningNumbers)
            winningCounts
        }.eachCount().filter { it.key >= 3 }
    }

    private fun matchWinningLottoNumbersCount(
        lottoNumbers: LottoNumbers,
        winningNumbers: List<Int>,
    ): Int {
        val winningSets = winningNumbers.toSet()
        return lottoNumbers.count(winningSets::contains)
    }

    companion object {
        val DEFAULT_RANK_PRICE =
            mapOf(
                6 to 2_000_000_000,
                5 to 1_500_000,
                4 to 50_000,
                3 to 5_000,
            )
    }
}
