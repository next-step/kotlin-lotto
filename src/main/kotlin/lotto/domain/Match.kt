package lotto.domain

import lotto.constant.FIFTH_RANK
import lotto.constant.FIRST_RANK
import lotto.constant.FOURTH_RANK
import lotto.constant.MATCH_COUNT_FIVE
import lotto.constant.MATCH_COUNT_FOUR
import lotto.constant.MATCH_COUNT_SIX
import lotto.constant.MATCH_COUNT_THREE
import lotto.constant.NO_RANK
import lotto.constant.THIRD_RANK

object Match {
    fun lottoNumber(
        userLotto: Lotto,
        winningLotto: Lotto,
    ): Int {
        val lottoNumbers: Set<LottoNumber> = userLotto.lottoNumbers
        val winningLottoNumbers: Set<LottoNumber> = winningLotto.lottoNumbers

        val matchCount = lottoNumbers.intersect(winningLottoNumbers).size
        return rank(matchCount)
    }

    private fun rank(matchCount: Int): Int {
        return when (matchCount) {
            MATCH_COUNT_SIX -> FIRST_RANK
            MATCH_COUNT_FIVE -> THIRD_RANK
            MATCH_COUNT_FOUR -> FOURTH_RANK
            MATCH_COUNT_THREE -> FIFTH_RANK
            else -> NO_RANK
        }
    }
}
