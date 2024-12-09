package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MAX_VALUE
import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_MIN_VALUE
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_COUNT

fun generateLottoNumbers(): Set<Int> {
    return (LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE)
        .toSet().shuffled().take(LOTTO_NUMBER_COUNT).sorted().toSet()
}
