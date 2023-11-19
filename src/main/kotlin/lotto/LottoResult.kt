package lotto
data class LottoResult(val resultList: List<LottoPrize>) {
    fun count(rank: LottoPrize) = resultList.count { it == rank }

    private val prizeMoney = run {
        var total = 0
        for (rank in LottoPrize.values()) {
            total += count(rank) * rank.prizeMoney
        }
        total
    }

    fun getProfitRate(purchase: Int): String {
        val profitRate = prizeMoney / purchase.toFloat()
        val truncatedProfitRate = (profitRate * 100).toInt() / 100.0
        return truncatedProfitRate.toString()
    }

    companion object {
        fun getResult(winningLotto: WinningLotto, lottos: List<Lotto>): LottoResult {
            val result = mutableListOf<LottoPrize>()
            for (lotto in lottos) {
                result.add(LottoPrize.of(winningLotto, lotto))
            }
            return LottoResult(result)
        }
    }
}
