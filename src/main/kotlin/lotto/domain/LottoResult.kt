package lotto.domain

@JvmInline
value class LottoResult(val value: HashMap<LottoRank, Int> = hashMapOf()) {
    fun add(lottoRank: LottoRank) {
        if (value.containsKey(lottoRank)) {
            value[lottoRank] = value[lottoRank]!! + 1
            return
        }
        value[lottoRank] = 1
    }

    fun getLottoRankCount(lottoRank: LottoRank): Int {
        return value[lottoRank] ?: 0
    }

    fun calculateProfitRate(amount: Int): Float {
        val totalWinningMoney = value.entries.sumOf { it.key.winningMoney * it.value }
        return totalWinningMoney.toFloat() / amount
    }
}
