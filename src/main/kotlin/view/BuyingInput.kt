package view

import domain.money.Money

data class BuyingInput(val amount: Int) {
    constructor(amount: String) : this(amount.toInt())

    fun toMoney(): Money = Money(amount)
}
