package view

import domain.money.Money

sealed class BuyingInputParsedResult

data class InvalidInput(val input: String, val warningMessage: String) : BuyingInputParsedResult()

data class BuyingInput(val amount: Long) : BuyingInputParsedResult() {
    fun toMoney(): Money = Money(amount)
}
