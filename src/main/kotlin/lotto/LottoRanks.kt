package lotto

class LottoRanks {
    private val lottoRanks: MutableMap<LottoRank, Int> = mutableMapOf()

    fun add(lottoRank: LottoRank) {
        lottoRanks[lottoRank] = lottoRanks.getOrDefault(lottoRank, 0) + 1
    }

    fun getRankCount(lottoRank: LottoRank): Int {
        return lottoRanks.getOrDefault(lottoRank, 0)
    }
}
