package com.nextstep.lotto.domain

data class LottoNumber(val number: Int) {
    init {
        validateLottoNumber(number)
    }

    private fun validateLottoNumber(number: Int) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw IllegalArgumentException("로또 숫자는 1~45사이여야 합니다.")
        }
    }

    fun isMatched(number: Int): Boolean {
        return this.number == number
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
