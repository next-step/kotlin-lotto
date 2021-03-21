package view

import domain.money.Money

data class BuyingInput(val amount: Int) {
    fun toMoney(): Money = Money(amount)
}
