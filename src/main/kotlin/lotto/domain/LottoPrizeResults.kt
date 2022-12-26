package lotto.domain

import lotto.model.LottoPrize

class LottoPrizeResults(
    private val prizes: List<LottoPrize>,
) {
    fun count(prize: LottoPrize): Int = prizes.count { it == prize }
}
