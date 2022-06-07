package lotto.model

class LottoResult(
    val lottoRankList: List<LottoRank?>,
    val profitRate: String
) {

    companion object {
        fun of(lottoList: List<Lotto>, winLottoNumbers: Lotto): LottoResult {
            val lottoRankList = lottoList.map { it.matches(winLottoNumbers) }.map { LottoRank.find(it) }
            val profitRate = calculateProfitRate(lottoRankList)
            return LottoResult(
                lottoRankList = lottoRankList,
                profitRate = profitRate
            )
        }

        private fun calculateProfitRate(lottoRankList: List<LottoRank?>): String {
            val profitRate = lottoRankList.sumOf { it?.price ?: 0 }.toFloat()
            return String.format("%.2f", (profitRate / (lottoRankList.size * 1000)))
        }
    }
}
