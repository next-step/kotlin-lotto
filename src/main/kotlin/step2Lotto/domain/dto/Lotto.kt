package step2Lotto.domain.dto

import step2Lotto.domain.LottoNumber

data class Lotto(
    val numbers: List<LottoNumber>
) {
    constructor(numbers: Array<Int>) : this(numbers.map { LottoNumber(it) })

    fun getLottoNumbers(): List<Int> {
        return numbers.map { it.value }
    }
}
