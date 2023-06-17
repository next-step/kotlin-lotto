package com.nextstep.second.lotto.domain

class Lotto(inputNumbers: List<Int>) {
    val numbers: List<LottoNumberVo>

    init {
        require(inputNumbers.toSet().size == LOTTO_LENGTH) { "로또는 서로다른 ${LOTTO_LENGTH}개의  숫자만큼 번호를 입력하셔야 합니다" }
        numbers = inputNumbers.map { LottoNumberVo(it) }
    }

    companion object {
        const val LOTTO_LENGTH = 6
        const val PRICE = 1_000
    }
}

@JvmInline
value class LottoNumberVo(val value: Int) {
    init {
        require(value in 1..45)
    }

    override fun toString(): String {
        return value.toString()
    }
}
