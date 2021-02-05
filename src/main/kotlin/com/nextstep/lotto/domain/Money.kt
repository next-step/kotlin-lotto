package com.nextstep.lotto.domain

class Money(var money: Int) {
    fun pay(price: Int) {
        require(money >= price) { "지불하기 위한 돈이 부족합니다." }

        money = money.minus(price)
    }

    init {
        require(money >= MINIMUM_PRICE) {
            throw IllegalArgumentException("최소 금액을 만족하지 못합니다.")
        }
    }

    companion object {
        const val MINIMUM_PRICE = 1000
    }
}
