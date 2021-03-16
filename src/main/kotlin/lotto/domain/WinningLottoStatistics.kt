package lotto.domain

class WinningLottoStatistics(
    lottoTickets: List<LottoTicket>,
    winningLottoNumbers: WinningLottoNumbers
) {
    val statistics: MutableMap<LottoRank, Int> = hashMapOf()

    init {
        initializeRankMap()

        lottoTickets.forEach {
            addRankStatistics(rank(it, winningLottoNumbers))
        }
    }

    private fun initializeRankMap() {
        LottoRank.values().forEach {
            statistics[it] = 0
        }
    }

    private fun addRankStatistics(lottoRank: LottoRank?) {
        if (lottoRank != null) statistics[lottoRank] = statistics.getOrDefault(lottoRank, DEFAULT_RANK_COUNT) + ADD_RANK_COUNT
    }

    private fun rank(lottoTicket: LottoTicket, winningLottoNumbers: WinningLottoNumbers): LottoRank? {
        return LottoRank.selectByMatchCount(winningLottoNumbers.countWinningNumbers(lottoTicket))
    }

    fun calculateProfitRate(buyingPrice: Int): Double {
        return statistics.entries.fold(0) {
            total, winningPrice -> total + winningPrice.key.winningMoney * winningPrice.value
        } / buyingPrice.toDouble()
    }

    companion object {
        private const val DEFAULT_RANK_COUNT = 0
        private const val ADD_RANK_COUNT = 1
    }
}
