package lotto.domain

class WinningLottoStatistics(
    lottoTickets: List<LottoTicket>,
    winningLottoNumbers: WinningLottoNumbers
) {
    val statistics: MutableMap<LottoRank, Int> = hashMapOf()
    var profitRate: Double = 0.0
        private set

    init {
        initializeRankMap()

        lottoTickets.forEach {
            addRankStatistics(rank(it, winningLottoNumbers))
        }

        profitRate = calculateProfitRate(lottoTickets.size * LottoMachine.LOTTO_TICKET_PRICE)
    }

    private fun initializeRankMap() {
        LottoRank.values().forEach {
            statistics[it] = 0
        }
    }

    private fun addRankStatistics(lottoRank: LottoRank?) {
        if (lottoRank == null) return
        statistics[lottoRank] = statistics.getOrDefault(lottoRank, 0) + 1
    }

    private fun rank(lottoTicket: LottoTicket, winningLottoNumbers: WinningLottoNumbers): LottoRank? {
        var matchCount = lottoTicket.lottoNumbers.filter { winningLottoNumbers.isContainLottoNumber(it) }.size
        return LottoRank.selectByMatchCount(matchCount)
    }

    private fun calculateProfitRate(buyingPrice: Int): Double {
        var sum = 0.0
        statistics.forEach {
            sum += it.key.winningMoney * it.value
        }

        return sum / buyingPrice.toDouble()
    }
}