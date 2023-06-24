package lotto.domain

class LottoDrawMachine(val winningLotto: WinningLotto) {

    fun draw(lottos: List<Lotto>): LottoDrawResult {
        val lottoRanks: List<LottoRank> = lottos.map { winningLotto.rank(it) }
        return LottoDrawResult.of(lottoRanks)
    }
}

class LottoDrawResult(val result: Map<LottoRank, Int>) {

    val totalReward: Int = result.entries.sumOf { (lottoRank, count) -> lottoRank.reward * count }
    val totalCountOfLottos: Int = result.values.sum()
    fun countOf(lottoRank: LottoRank): Int {
        return result[lottoRank] ?: 0
    }
    fun profitability(): Double {
        val totalPurchaseAmount = totalCountOfLottos * LottoStore.LOTTO_PRICE
        return (totalReward / totalPurchaseAmount).toDouble()
    }

    companion object {
        fun of(lottoRanks: List<LottoRank>): LottoDrawResult {
            val groupingBy: Map<LottoRank, Int> = lottoRanks.groupingBy { it }.eachCount()
            return LottoDrawResult(groupingBy)
        }
    }
}
