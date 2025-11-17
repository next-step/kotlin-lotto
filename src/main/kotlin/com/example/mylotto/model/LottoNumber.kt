package com.example.mylotto.model

data class LottoNumber(
    val number: Int,
) {
    init {
        require(number in 1..45) { "Number must be between 1 and 45." }
    }
}
