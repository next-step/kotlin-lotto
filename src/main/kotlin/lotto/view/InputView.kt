package lotto.view

import lotto.domain.Lotto

class InputView {
    fun readMoney(): Int {
        println(INPUT_MONEY_MSG)
        return validateMoney(readLine())
    }

    fun validateMoney(money: String?): Int {
        require(money != null && money.toIntOrNull() != null) { INVALID_MONEY_EXCEPTION_MSG }
        return money.toInt()
    }

    fun readWinningNums(): Lotto {
        println(INPUT_WINNING_NUMS_MSG)
        return parseToWinningNums(readLine())
    }

    fun parseToWinningNums(nums: String?): Lotto {
        require(nums != null) { INVALID_WINNING_NUMS_EXCEPTION_MSG }

        val stringNums = nums.split(WINNING_NUM_DELIMITER)
        return Lotto(stringNums.map { convertToLottoNum(it) })
    }

    private fun convertToLottoNum(num: String?): Int {
        require(num != null && num.toIntOrNull() != null) { INVALID_WINNING_NUMS_EXCEPTION_MSG }
        return num.toInt()
    }

    companion object {
        private const val INPUT_MONEY_MSG = "구입금액을 입력해 주세요."
        private const val INVALID_MONEY_EXCEPTION_MSG = "구입금액을 바르게 입력해 주세요. (숫자만 가능)"
        private const val INPUT_WINNING_NUMS_MSG = "지난 주 당첨 번호를 입력해 주세요."
        private const val INVALID_WINNING_NUMS_EXCEPTION_MSG =
            "당첨 번호를 바르게 입력해 주세요. (1 ~ 45 사이의 서로 다른 6개의 숫자를 쉼표로 구분하여 입력)"
        private val WINNING_NUM_DELIMITER = ",\\s*".toRegex()
    }
}
