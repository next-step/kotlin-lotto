package com.example.mylotto.model

class LottoWinningNumbers private constructor(
    private val numbers: Set<LottoNumber>,
) {
    constructor(numberList: List<LottoNumber>) : this(
        numberList.toSet(),
    )
}
