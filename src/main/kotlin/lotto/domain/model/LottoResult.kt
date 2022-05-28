package lotto.domain.model

@JvmInline
value class LottoResult(val value: List<LottoWinning>) {
    init {
        require(isValidResult()) {
            MESSAGE_INVALID_LOTTO_RESULT
        }
    }

    private fun isValidResult(): Boolean {
        val lottoRanks = LottoRank.winnerPlace()
        return value.size == lottoRanks.size && lottoRanks.all { rank ->
            rank in this
        }
    }

    private operator fun contains(rank: LottoRank): Boolean = value.find { it.rank == rank } != null

    operator fun get(rank: LottoRank): LottoWinning = value.first { it.rank == rank }

    fun getTotalEarns(): Int = value.sumOf { lottoWinning ->
        lottoWinning.rank.winnings * lottoWinning.count
    }

    companion object {
        private const val MESSAGE_INVALID_LOTTO_RESULT = "LottoResult는 1, 2, 3, 4등 당첨 결과를 모두 포함하고 있어야 합니다."

        fun from(lottoWinningMap: Map<NumberOfMatches, Int>): LottoResult {
            fun getCount(numberOfMatches: NumberOfMatches): Int {
                return lottoWinningMap[numberOfMatches] ?: 0
            }

            val lottoWinnings = LottoRank.winnerPlace().map { lottoRank ->
                LottoWinning(lottoRank, getCount(lottoRank.numberOfMatches))
            }

            return LottoResult(lottoWinnings)
        }
    }
}
