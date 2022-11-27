package lotto.model

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Quantity(amount: String) {
    var quantity = 0

    init {
        checkValidNumber(amount)
        quantity = amount.toInt()
    }

    private fun checkValidNumber(amount: String) {
        try {
            amount.toInt()
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException("Invalid Number")
        }
    }
}
