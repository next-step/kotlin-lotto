package com.nextstep.second.lotto.domain

@JvmInline
value class LottoNumberVo(val value: Int) {
    init {
        require(value in 1..45)
    }

    override fun toString(): String {
        return value.toString()
    }
}
