package lotto.domain

class LottoProfitRate(val profitRate: Double) {
    fun getProfitRateDescription(): String {
        if (profitRate > 1.0) {
            return "이득이에요"
        }
        return "손해에요"
    }

    companion object {
        fun from(lottoRankMatchMap: LottoRankMatchMap): LottoProfitRate {
            return LottoProfitRate(lottoRankMatchMap.getProfitRate())
        }
    }
}
