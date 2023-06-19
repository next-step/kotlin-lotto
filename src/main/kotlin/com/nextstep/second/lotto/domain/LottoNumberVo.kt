package com.nextstep.second.lotto.domain

@JvmInline
value class LottoNumberVo(val value: Int) {
    init {
        require(value in 1..45)
    }

    fun isEquals(other: LottoNumberVo): Boolean {
        return other.value == this.value
    }

    override fun toString(): String {
        return value.toString()
    }
}
