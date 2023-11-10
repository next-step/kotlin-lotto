package lotto.domain

open class Money(val money: Int) {

    fun minus(otherMoney: Money): Money {
        require(money >= otherMoney.money) {
            "잔여 금액이 부족합니다."
        }
        return Money(money - otherMoney.money)
    }

    fun count(): Int {
        return money / LOTTO_PRICE
    }

    companion object {
        const val LOTTO_PRICE = 1_000

        fun fromCount(count: Int): Money {
            return Money(count * LOTTO_PRICE)
        }
    }
}
