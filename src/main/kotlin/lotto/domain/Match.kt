package lotto.domain

class Match {
    companion object {
        private const val MATCH_COUNT_FIRST_PRIZE = 6
        private const val MATCH_COUNT_SECOND_PRIZE = 5
        private const val MATCH_COUNT_THIRD_PRIZE = 4
        private const val MATCH_COUNT_FOURTH_PRIZE = 3
        private const val RANK_FIRST = 1
        private const val RANK_SECOND = 2
        private const val RANK_THIRD = 3
        private const val RANK_FOURTH = 4
        private const val RANK_NO_PRIZE = 0

        fun lottoNumber(
            userLotto: Lotto,
            winningLotto: Lotto,
        ): Int {
            val lottoNumbers: Set<LottoNumber> = userLotto.lottoNumbers
            val winningLottoNumbers: Set<LottoNumber> = winningLotto.lottoNumbers

            val matchCount = lottoNumbers.filter { winningLottoNumbers.contains(it) }.size
            return rank(matchCount)
        }

        private fun rank(matchCount: Int): Int {
            return when (matchCount) {
                MATCH_COUNT_FIRST_PRIZE -> RANK_FIRST
                MATCH_COUNT_SECOND_PRIZE -> RANK_SECOND
                MATCH_COUNT_THIRD_PRIZE -> RANK_THIRD
                MATCH_COUNT_FOURTH_PRIZE -> RANK_FOURTH
                else -> RANK_NO_PRIZE
            }
        }
    }
}
