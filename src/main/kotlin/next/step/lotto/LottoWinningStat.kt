package next.step.lotto

@JvmInline
value class LottoWinningStat(val stats: Map<LottoWinningCount, Int>) : Map<LottoWinningCount, Int> by stats {
    companion object {
        fun of(stats: Map<LottoWinningCount, Int>): LottoWinningStat = LottoWinningStat(stats)
    }

}