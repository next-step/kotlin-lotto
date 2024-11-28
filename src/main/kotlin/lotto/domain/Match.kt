package lotto.domain

import lotto.constant.FIFTH_RANK_NUMBER
import lotto.constant.FIRST_RANK_NUMBER
import lotto.constant.FOURTH_RANK_NUMBER
import lotto.constant.MATCH_COUNT_FIVE
import lotto.constant.MATCH_COUNT_FOUR
import lotto.constant.MATCH_COUNT_SIX
import lotto.constant.MATCH_COUNT_THREE
import lotto.constant.NO_RANK_NUMBER
import lotto.constant.THIRD_RANK_NUMBER

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
                MATCH_COUNT_SIX -> FIRST_RANK_NUMBER
                MATCH_COUNT_FIVE -> THIRD_RANK_NUMBER
                MATCH_COUNT_FOUR -> FOURTH_RANK_NUMBER
                MATCH_COUNT_THREE -> FIFTH_RANK_NUMBER
                else -> NO_RANK_NUMBER
            }
        }
    }
}
