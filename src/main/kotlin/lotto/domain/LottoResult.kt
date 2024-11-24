package lotto.domain

class LottoResult(
    val lottos: Lottos,
    val lottoMatchMap: LottoMatchMap,
    val profitRate: Double,
) {
    companion object {
        fun getLottoResult(
            lottos: Lottos,
            winningNumbers: WinningNumbers,
            bonusNumber: Int,
        ): LottoResult {
            val lottoMatchMap = LottoMatchMap.getLottoMatchMap(lottos, winningNumbers, bonusNumber)
            val profitRate = lottoMatchMap.getProfitRate()

            return LottoResult(lottos, lottoMatchMap, profitRate)
        }
    }
}
