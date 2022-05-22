package lotto.view

import lotto.domain.InputValidator

class InputView {
    fun getUserMoney(): Int {
        var moneyInput: String
        do {
            moneyInput = getUserMoneyInput()
        } while (isValidMoney(moneyInput).not())

        return moneyInput.toInt()
    }

    private fun isValidMoney(money: String): Boolean {
        return try {
            InputValidator.checkIsValidMoney(money)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    private fun getUserMoneyInput(): String {
        println(MONEY_INPUT_MESSAGE)
        return readln()
    }

    companion object {
        private const val MONEY_INPUT_MESSAGE = "구매금액을 입력해 주세요."
    }
}