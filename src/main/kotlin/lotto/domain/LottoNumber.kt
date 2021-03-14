package lotto.domain

import lotto.domain.strategy.LottoNumberStrategy.Companion.MAX_LOTTO_NUMBER
import lotto.domain.strategy.LottoNumberStrategy.Companion.MIN_LOTTO_NUMBER

data class LottoNumber(private val input: String) {
    private val number: Int

    init {
        val number = input.toInt()
        validateRange(number)
        this.number = number
    }

    constructor(input: Int) : this(input.toString())

    private fun validateRange(number: Int) {
        require(number in (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)) { "로또 번호는 $MIN_LOTTO_NUMBER 이상 $MAX_LOTTO_NUMBER 이하여야 합니다." }
    }
}
