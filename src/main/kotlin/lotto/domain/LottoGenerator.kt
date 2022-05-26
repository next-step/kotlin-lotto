package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE

class LottoGenerator {
    fun generateNumbers(): List<LottoNumber> {
        return LOTTO_NUMBER_RANGE
            .toList()
            .shuffled()
            .take(6)
            .map { LottoNumber(it) }
    }
}
