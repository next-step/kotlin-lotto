package lotto.domain

import lotto.model.LottoPrize

class LottoPrizeResults(
    private val prizes: List<LottoPrize>,
) {
    val size: Int
        get() = prizes.size

    fun count(prize: LottoPrize): Int = prizes.count { it == prize }
}
