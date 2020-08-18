package com.nextstep.lotto.domain

import java.lang.IllegalArgumentException

object LottoNumbers {
    private val lottoNumbers: List<LottoNumber> = (1..45).map { LottoNumber(it) }

    fun drawRandomNumbers(): List<LottoNumber> {
        return lottoNumbers.shuffled().subList(0, 6)
    }

    fun valueOf(number: Int): LottoNumber {
        return lottoNumbers.find { lottoNumber -> lottoNumber.isMatched(number) }
            ?: throw IllegalArgumentException("로또 숫자가 올바르지 않습니다.")
    }
}
