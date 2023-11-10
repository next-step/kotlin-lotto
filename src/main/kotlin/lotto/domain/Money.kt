package lotto.domain

class Money(val money: Int) {
    init {
        require(money >= LOTTO_PRICE) {
            "로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다."
        }
    }

    fun minus(otherMoney: Money): Money {
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
