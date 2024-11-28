package lotto.domain

class LottoProfitRate(val profitRate: Double) {
    companion object {
        fun from(lottoRankMatchMap: LottoRankMatchMap): LottoProfitRate {
            return LottoProfitRate(lottoRankMatchMap.getProfitRate())
        }
    }
}
