package lotto.domain

class LottoOutcome(
    val lottoRankMatchMap: LottoRankMatchMap,
    val lottoProfitRate: LottoProfitRate,
) {
    companion object {
        fun of(
            lottos: Lottos,
            winningNumbers: WinningNumbers,
        ): LottoOutcome {
            val lottoRankMatchMap = LottoRankMatchMap.getLottoMatchMap(lottos, winningNumbers)
            val profitRate = LottoProfitRate.from(lottoRankMatchMap)

            return LottoOutcome(lottoRankMatchMap, profitRate)
        }
    }
}
