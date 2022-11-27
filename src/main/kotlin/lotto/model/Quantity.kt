package lotto.model

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Quantity(amount: String) {
    var quantity = 0

    init {
        checkValidNumber(amount)
        quantity = amount.toInt()
        checkMinimumAmount()
        checkUnit()
    }

    private fun checkValidNumber(amount: String) {
        try {
            amount.toInt()
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException("Invalid Number")
        }
    }

    private fun checkMinimumAmount() {
        require(quantity >= 1000) { "1000원 이상을 결제해주세요." }
    }

    private fun checkUnit() {
        require(quantity % 1000 == 0) { "1000원 단위로 결제해주세요." }
    }
}
