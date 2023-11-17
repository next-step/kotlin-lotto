package lotto.domain

open class Money(val money: Int) {

    init {
        require(money >= 0) {
            "금액은 0원 미만일 수 없습니다."
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
