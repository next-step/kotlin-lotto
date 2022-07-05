package lotto.domain

class User(
    money: Money,
    val manualAmount: Int
) {

    var money = money
        private set

    fun pay(amount: Money) {
        money = money.sub(amount)
    }
}
