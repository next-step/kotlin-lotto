package lotto.domain

import lotto.model.LottoErrorCode

@JvmInline
value class LottoNumber(private val number: Int) {

    init {
        require(value = LOTTO_NUMBER_RANGE.contains(value = number)) {
            LottoErrorCode.INVALID_LOTTO_NUMBER.message("$LOTTO_NUMBER_RANGE $number")
        }
    }

    override fun toString(): String = number.toString()

    companion object {
        val LOTTO_NUMBER_RANGE = 1 until 46
    }
}
