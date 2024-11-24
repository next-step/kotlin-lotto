package autolotto.view

import autolotto.valid.Valid

object InputView {
    private val LOTTO_AMOUNT = 1000

    fun getLottoGameCount(amount: Int): Int {
        return amount / LOTTO_AMOUNT
    }

    fun printLottoGameCount(gameCount: Int) {
        println("${gameCount}개를 구매했습니다.")
    }

    fun getLottoPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input: Int = readLine()?.toIntOrNull() ?: throw RuntimeException("0 이 아닌 숫자를 입력해주세요")
        val convertValue = Valid.inputNumberValid(input)
        Valid.purchaseAmountValid(convertValue)
        return convertValue
    }

    fun getWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input: String? = readLine()
        if (input.isNullOrEmpty()) {
            throw RuntimeException("당청번호를 입력해주세요.")
        }
        val splitValue = splitWinningNumbers(input)
        return splitValue.map { e -> Valid.inputNumberValid(Valid.run { stringToInt(e) }) }.toList()
    }

    fun printInputWinningNumber(winningNumbers: List<Int>) {
        val winningNumber = winningNumbers.joinToString { "," }
        println(winningNumber)
    }

    private fun splitWinningNumbers(input: String): List<String> {
        return input.split(",").map { e -> e.trim() }
    }
}
