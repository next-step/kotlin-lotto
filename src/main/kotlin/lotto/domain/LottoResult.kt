package lotto.domain

@JvmInline
value class LottoResult(val value: Map<LottoRank, Int>) {
    fun calculateProfitRate(amount: Int): Float {
        val totalWinningMoney = value.entries.sumOf { it.key.winningMoney * it.value }
        return totalWinningMoney.toFloat() / amount
    }
}
