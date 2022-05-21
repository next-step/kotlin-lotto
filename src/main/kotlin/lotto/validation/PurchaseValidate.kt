package lotto.validation

import lotto.exception.MinimumPurchaseMoneyException
import lotto.exception.NotNumericException

class PurchaseValidate {

    fun validate(toCheck: String) {
        validateNotString(toCheck)
        validatePurchaseMoney(toCheck.toInt())
    }

    private fun validateNotString(toCheck: String) {
        if (toCheck.toIntOrNull() == null) {
            throw NotNumericException("로또 구매를 위해서는 숫자를 입력하셔야 합니다.")
        }
    }

    private fun validatePurchaseMoney(money: Int) {
        if (money < MINIMUM_PURCHASE_MONEY) {
            throw MinimumPurchaseMoneyException("최소 ${MINIMUM_PURCHASE_MONEY}원 이상 지불하셔야 로또 구매가 가능합니다.")
        }
    }

    companion object {
        const val MINIMUM_PURCHASE_MONEY = 1_000
    }
}
