package lotto.dto

import lotto.utils.LOTTO_NUMBER_RANGE

data class LottoNumber(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == 6)
        numbers.forEach { require(it in LOTTO_NUMBER_RANGE) }
    }

    fun compare(lottoNumber: LottoNumber): Int {
        return numbers.intersect(lottoNumber.numbers.toSet()).count()
    }
}
