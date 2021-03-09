package lotto.domain

class LottoGame(private val winnerNumbers: List<Int>) {
    private val matchedLottoRank = mutableMapOf<LottoRank, Int>().apply {
        LottoRank.values().forEach { put(it, 0) }
    }

    fun findMatchCount(lottoNumbers: List<Int>): Int {
        return lottoNumbers.filter {
            winnerNumbers.contains(it)
        }.count()
    }

    fun addMatchedLottoRankCount(lottoRank: LottoRank) {
        matchedLottoRank[lottoRank] = matchedLottoRank[lottoRank]?.plus(1) ?: return
    }

    fun getRankCount(lottoRank: LottoRank): Int {
        return matchedLottoRank[lottoRank] ?: 0
    }
}
