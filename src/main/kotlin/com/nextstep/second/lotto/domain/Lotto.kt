package com.nextstep.second.lotto.domain

class Lotto private constructor(val numbers: List<LottoNumberVo>) {

    fun contains(num: LottoNumberVo): Boolean {
        return numbers.any { it == num }
    }

    companion object {
        const val LOTTO_LENGTH = 6

        fun of(inputNumbers: List<Int>): Lotto {
            require(inputNumbers.toSet().size == LOTTO_LENGTH) { "로또는 서로다른 ${LOTTO_LENGTH}개의  숫자만큼 번호를 입력하셔야 합니다" }
            val numbers = inputNumbers.map { LottoNumberVo(it) }
            return Lotto(numbers)
        }
    }
}
