package lotto.domain

class WinningLottoStatistics(
    lottoTickets: List<Lotto>,
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
        LottoRank.valuesNotIncludeNotPlace().forEach {
            statistics[it] = 0
        }
    }

    private fun addRankStatistics(lottoRank: LottoRank) {
        if (lottoRank != LottoRank.NOT_PLACE) {
            val prevRankCount = statistics.getOrDefault(lottoRank, DEFAULT_RANK_COUNT)
            statistics[lottoRank] = prevRankCount + ADD_RANK_COUNT
        }
    }

    private fun rank(lotto: Lotto, winningLottoNumbers: WinningLottoNumbers): LottoRank {
        val winningNumberCount = winningLottoNumbers.countWinningNumbers(lotto)
        val matchBonus = lotto.contains(winningLottoNumbers.bonusLotto)
        return LottoRank.selectByMatchCount(winningNumberCount, matchBonus)
    }

    fun calculateProfitRate(buyingPrice: Int): Double {
        return statistics.entries.fold(0) { total, winningPrice ->
            total + winningPrice.key.winningMoney * winningPrice.value
        } / buyingPrice.toDouble()
    }

    companion object {
        private const val DEFAULT_RANK_COUNT = 0
        private const val ADD_RANK_COUNT = 1
    }
}
