package lotto.domain

import lotto.constant.MATCH_COUNT_FIVE
import lotto.constant.MATCH_COUNT_FOUR
import lotto.constant.MATCH_COUNT_SIX
import lotto.constant.MATCH_COUNT_THREE
import lotto.constant.RANK_FIFTH
import lotto.constant.RANK_FIRST
import lotto.constant.RANK_FOURTH
import lotto.constant.RANK_NO_PRIZE
import lotto.constant.RANK_THIRD

class Match {
    companion object {
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
                MATCH_COUNT_SIX -> RANK_FIRST
                MATCH_COUNT_FIVE -> RANK_THIRD
                MATCH_COUNT_FOUR -> RANK_FOURTH
                MATCH_COUNT_THREE -> RANK_FIFTH
                else -> RANK_NO_PRIZE
            }
        }
    }
}
