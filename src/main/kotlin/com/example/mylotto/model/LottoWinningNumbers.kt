package com.example.mylotto.model

class LottoWinningNumbers private constructor(
    val numbers: Set<LottoNumber>,
) {
    companion object {
        fun of(numberList: List<LottoNumber>): LottoWinningNumbers {
            require(numberList.size == 6) { "There must be exactly 6 winning numbers." }
            val set = numberList.toSet()
            require(set.size == 6) { "There must be no duplicates." }
            return LottoWinningNumbers(set)
        }
    }
}
