package lotto.domain

data class WinningLottoNumbers(
    private val lottoNumbers: LottoNumbers,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!lottoNumbers.lottoNumbers.contains(bonusLottoNumber)) { INVALID_BONUS_BALL_ERROR_MESSAGE }
    }
    fun makeStatistics(lotteries: List<LottoNumbers>): WinningStatistics {
        val matchResult = lotteries.map {
            Pair(lottoNumbers.getNumberOfMatch(it), it.isMatchBonusLottoNumber(bonusLottoNumber))
        }
        val ranks = matchResult.map { Rank.valueOf(it.first, it.second) }

        return WinningStatistics(statistics = countRanks(ranks))
    }

    private fun countRanks(ranks: List<Rank>): Map<Rank, Int> {
        val statistics = INITIAL_STATISTICS.toMutableMap()
        ranks.forEach { statistics[it] = statistics[it]!! + 1 }

        return statistics.toMap()
    }

    companion object {
        private const val INVALID_BONUS_BALL_ERROR_MESSAGE = "보너스 볼은 당첨 번호와 중복되지 않는 수여야 합니다."
        private const val INITIAL_COUNT = 0
        private val INITIAL_STATISTICS = Rank.values().associateWith { INITIAL_COUNT }
    }
}
