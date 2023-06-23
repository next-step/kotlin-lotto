package lotto.domain

import lotto.domain.LottoNumberGenerator.Companion.LOTTO_SIZE

class Numbers(
    val values: List<Int>
) {
    init {
        require(values.size == LOTTO_SIZE)
    }
}