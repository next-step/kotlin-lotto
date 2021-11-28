package lotto.view

class InputView {
    fun readMoney(): Int {
        println(INPUT_MONEY_MSG)
        return invalidateMoney(readLine())
    }

    fun invalidateMoney(money: String?): Int {
        require(money != null && money.toIntOrNull() != null) { ILLEGAL_MONEY_MSG }
        return money.toInt()
    }

    companion object {
        private const val INPUT_MONEY_MSG = "구입금액을 입력해 주세요."
        private const val ILLEGAL_MONEY_MSG = "구입금액을 바르게 입력해 주세요. (숫자만 가능)"
    }
}
