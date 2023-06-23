package lotto

import lotto.LottoNumberGenerator.Companion.LOTTO_SIZE

class Numbers(
    val values: List<Int>
) {
    init {
        require(values.size == LOTTO_SIZE)
    }
}