package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant

class LottoWinningNumbers private constructor(
    val numbers: Set<LottoNumber>,
    val bonusNumber: LottoNumber,
) {
    companion object {
        fun of(
            numberList: List<LottoNumber>,
            bonusNumber: LottoNumber,
        ): LottoWinningNumbers {
            require(numberList.size == LottoConstant.LOTTO_NUMBER_SIZE) { "There must be exactly 6 winning numbers." }
            val set = (numberList + bonusNumber).toSet()
            require(set.size == LottoConstant.LOTTO_NUMBER_SIZE + 1) { "There must be no duplicates." }
            return LottoWinningNumbers(numberList.toSet(), bonusNumber)
        }
    }
}
