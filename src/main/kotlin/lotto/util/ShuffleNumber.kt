package lotto.util

import lotto.domain.LottoStore

fun shuffleNumber(
    start: Int = LottoStore.LOTTO_NUMBER_MIN,
    end: Int = LottoStore.LOTTO_NUMBER_MAX
): List<Int> {
    return listOf(start..end)
        .flatten()
        .shuffled()
}
