package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant

class LottoWinningNumbers private constructor(
    val numbers: Set<LottoNumber>,
) {
    companion object {
        fun of(numberList: List<LottoNumber>): LottoWinningNumbers {
            require(numberList.size == LottoConstant.LOTTO_NUMBER_SIZE) { "There must be exactly 6 winning numbers." }
            val set = numberList.toSet()
            require(set.size == LottoConstant.LOTTO_NUMBER_SIZE) { "There must be no duplicates." }
            return LottoWinningNumbers(set)
        }
    }
}
