package com.nextstep.second.lotto.domain

@JvmInline
value class LottoNumberVo private constructor(private val value: Int) {
    init {
        require(value in LOTTO_NUMBER_UNDER_BOUNDARY..LOTTO_NUMBER_UPPER_BOUNDARY)
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        const val LOTTO_NUMBER_UNDER_BOUNDARY = 1
        const val LOTTO_NUMBER_UPPER_BOUNDARY = 45
        private val CACHE = (LOTTO_NUMBER_UNDER_BOUNDARY..LOTTO_NUMBER_UPPER_BOUNDARY).associateWith {
            LottoNumberVo(it)
        }

        fun of(num: Int): LottoNumberVo {
            return CACHE[num] ?: throw IllegalArgumentException("로또 숫자 범위를 확인해주세요")
        }
    }
}
