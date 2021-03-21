package view

import domain.money.Money

data class BuyingInput(val amount: Long) {
    constructor(amount: String) : this(amount.toLong())

    fun toMoney(): Money = Money(amount)
}
