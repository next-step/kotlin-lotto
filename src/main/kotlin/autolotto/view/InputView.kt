package autolotto.view

import autolotto.valid.Valid

class InputView {

    fun getLottoGameCount(): Int {
        println("구입금액을 입력해 주세요.")
        val input: Int = readLine()?.toIntOrNull() ?: throw RuntimeException("0 이 아닌 숫자를 입력해주세요")
        val convertValue = valid.inputNumberValid(input)
        valid.purchaseAmountValid(convertValue)
        return convertValue / LOTTO_AMOUNT
    }

    fun getWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input: String? = readLine()
        if (input.isNullOrEmpty()) { throw RuntimeException("당청번호를 입력해주세요.")}
        val splitValue = splitWinningNumbers(input)
        return splitValue.map { e -> valid.inputNumberValid(valid.run { stringToInt(e.trim()) }) }.toList()
    }
    private fun splitWinningNumbers(input: String): List<String> {
        return input.split(",")
    }

    companion object {
        private val LOTTO_AMOUNT = 1000
        private val valid = Valid()
    }
}