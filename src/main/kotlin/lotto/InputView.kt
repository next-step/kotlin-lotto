package lotto

object InputView {
    const val DELIMITER = ","
    fun inputAmountOfMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputWinningNumbers(): String {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readLine()!!
        validateDelimiter(winningNumbers)
        return winningNumbers
    }

    private fun validateDelimiter(winningNumbers: String) {
        if (!winningNumbers.contains(DELIMITER)) {
            throw IllegalArgumentException(",는 반드시 입력하세요.")
        }
    }
}
