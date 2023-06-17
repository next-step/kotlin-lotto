package next.step.lotto.domain

@JvmInline
value class LottoWinningStat(private val stats: Map<LottoRank, Int>) : Map<LottoRank, Int> by stats {
    fun performance(payment: Int): String = "%.2f".format(totalWinnings() / payment.toDouble())

    private fun totalWinnings(): Int = stats.map { it.key.winnings * it.value }.sum()

    companion object {
        fun of(stats: Map<LottoRank, Int>): LottoWinningStat {
            val initStats = LottoRank.values().associateWith { 0 }
            return LottoWinningStat(initStats + stats)
        }
    }

}