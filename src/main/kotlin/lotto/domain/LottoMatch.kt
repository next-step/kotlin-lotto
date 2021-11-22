package lotto.domain

import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.WinningLotto

object LottoMatch {

    private const val LOTTO_MIN_MATCH = 3
    private const val LOTTO_MAX_MATCH = 6
    private const val LOTTO_MATCH_UP_COUNT = 1

    fun match(userLottoNumbers: List<Lotto>, winningLotto: WinningLotto): Map<Int, Int> {

        val lottoPrizeMap = (LOTTO_MIN_MATCH..LOTTO_MAX_MATCH)
            .associateWith { 0 }
            .toMutableMap()

        for (lotto in userLottoNumbers) {
            val matchCount = lotto.getLottoNumber()
                .filter { winningLotto.containsLottoNumber(it) }
                .size

            lottoMinMatchGreaterThanEqual(matchCount, lottoPrizeMap)
        }

        return lottoPrizeMap.toMap()
    }

    private fun lottoMinMatchGreaterThanEqual(matchCount: Int, lottoPrizeMap: MutableMap<Int, Int>) {
        if (matchCount >= LOTTO_MIN_MATCH)
            lottoPrizeMap[matchCount] = +LOTTO_MATCH_UP_COUNT
    }
}
