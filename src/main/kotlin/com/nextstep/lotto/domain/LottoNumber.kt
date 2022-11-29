package com.nextstep.lotto.domain

import java.lang.IllegalArgumentException

data class LottoNumber(private val number: Int) {

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        private val RANGE = LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER

        private val NUMBERS: Map<Int, LottoNumber> = RANGE.associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return NUMBERS[value]
                ?: throw IllegalArgumentException("로또 번호는 $LOTTO_MIN_NUMBER ~ $LOTTO_MAX_NUMBER 사이여야 합니다.")
        }

        fun getAvailableNumbers(): List<LottoNumber> {
            return NUMBERS.values.toList()
        }
    }

    override fun toString(): String {
        return number.toString()
    }
}
