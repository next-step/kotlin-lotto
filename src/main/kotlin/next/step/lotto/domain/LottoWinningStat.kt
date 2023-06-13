package next.step.lotto.domain

@JvmInline
value class LottoWinningStat(private val stats: Map<LottoWinningCount, Int>) : Map<LottoWinningCount, Int> by stats {
    fun performance(payment: Int): String = "%.2f".format(totalWinnings() / payment.toDouble())

    private fun totalWinnings(): Int = stats.map { it.key.winnings * it.value }.sum()

    companion object {
        fun of(stats: Map<LottoWinningCount, Int>): LottoWinningStat {
            val initStats = LottoWinningCount.values().associateWith { 0 }
            return LottoWinningStat(initStats + stats)
        }
    }

}