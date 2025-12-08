package com.example.mylotto.model

import com.example.mylotto.constant.LottoConstant

class LottoNumbers private constructor(
    val numbers: Set<LottoNumber>,
) {
    companion object {
        fun of(numberList: List<LottoNumber>): LottoNumbers {
            require(numberList.size == LottoConstant.LOTTO_NUMBER_SIZE) { "There must be exactly 6 winning numbers." }
            val set = numberList.toSet()
            require(set.size == LottoConstant.LOTTO_NUMBER_SIZE) { "There must be no duplicates." }
            return LottoNumbers(set)
        }

        fun auto(): LottoNumbers {
            val lottoNumbers =
                (1..LottoConstant.LOTTO_NUMBER_MAX)
                    .shuffled()
                    .take(LottoConstant.LOTTO_NUMBER_SIZE)
                    .sorted()
                    .map { LottoNumber(it) }
                    .toSet()
            return LottoNumbers(lottoNumbers)
        }
    }
}
