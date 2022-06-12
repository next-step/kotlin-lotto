package lotto.domain.model

@JvmInline
value class LottoResult private constructor(val value: List<LottoWinning>) {
    private operator fun contains(rank: LottoRank): Boolean = value.find { it.rank == rank } != null

    operator fun get(rank: LottoRank): LottoWinning = value.first { it.rank == rank }

    fun getTotalEarns(): Int = value.sumOf { lottoWinning ->
        lottoWinning.rank.winnings * lottoWinning.count
    }

    companion object {
        fun from(lottoWinningMap: Map<LottoRank, Int>): LottoResult {
            fun getCount(lottoRank: LottoRank): Int {
                return lottoWinningMap[lottoRank] ?: 0
            }

            val lottoWinnings = LottoRank.winnerPlace().map { lottoRank ->
                LottoWinning(lottoRank, getCount(lottoRank))
            }

            return LottoResult(lottoWinnings)
        }
    }
}
