package lotto.view

class InputView {
    fun readMoney(): Int {
        println(INPUT_MONEY_MSG)
        return validateMoney(readLine())
    }

    fun validateMoney(money: String?): Int {
        require(money != null && money.toIntOrNull() != null) { INVALID_MONEY_EXCEPTION_MSG }
        return money.toInt()
    }

    companion object {
        private const val INPUT_MONEY_MSG = "구입금액을 입력해 주세요."
        private const val INVALID_MONEY_EXCEPTION_MSG = "구입금액을 바르게 입력해 주세요. (숫자만 가능)"
    }
}
