package lotto.model

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Quantity(money: String) {
    var quantity = 0

    init {
        checkValidNumber(money)
        quantity = money.toInt()
        checkMinimumAmount()
        checkUnit()
        quantity = money.toInt() / 1000
    }

    private fun checkValidNumber(amount: String) {
        try {
            amount.toInt()
        } catch (error: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.")
        }
    }

    private fun checkMinimumAmount() {
        require(quantity >= 1000) { "1000원 이상을 결제해주세요." }
    }

    private fun checkUnit() {
        require(quantity % 1000 == 0) { "1000원 단위로 결제해주세요." }
    }
}
