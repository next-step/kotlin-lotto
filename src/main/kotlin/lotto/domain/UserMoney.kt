package lotto.domain

@JvmInline
value class UserMoney(val money: Int = 0) {

    fun getLottoCount(): Int {
        return money / EACH_LOTTO_PRICE
    }

    operator fun plus(other: UserMoney): UserMoney {
        return UserMoney(money + other.money)
    }

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
    }
}
