package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant

data class LottoNumber(
    val number: Int,
) {
    init {
        require(number in 1..LottoConstant.LOTTO_NUMBER_MAX) { "Number must be between 1 and 45." }
    }
}
