package lotto.view

object InputView {
    private const val WINNING_NUMBERS_INPUT_DELIMITER = ","

    fun readPurchaseAmountInput(): Long {
        println("구입금액을 입력해 주세요.")
        return readln().toLong()
    }

    fun readWinningNumbersInput(): List<Int> {
        println("지난주 당첨 번호를 입력해 주세요.")
        return readln().split(WINNING_NUMBERS_INPUT_DELIMITER)
            .map { it.trim().toInt() }
    }
}
