package com.nextstep.lotto.domain

class Money(val price: Int) {
    init {
        require(price >= MINIMUM_PRICE) {
            throw IllegalArgumentException("최소 금액을 만족하지 못합니다.")
        }
    }

    companion object {
        const val MINIMUM_PRICE = 1000
    }
}
