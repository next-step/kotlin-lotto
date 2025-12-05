package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant

@JvmInline
value class LottoNumber private constructor(
    val number: Int,
) {
    companion object {
        private val cached: Map<Int, LottoNumber> =
            (1..LottoConstant.LOTTO_NUMBER_MAX)
                .associateWith { LottoNumber(it) }

        fun of(number: Int): LottoNumber =
            cached[number]
                ?: throw IllegalArgumentException("Number must be between 1 and 45.")
    }
}
