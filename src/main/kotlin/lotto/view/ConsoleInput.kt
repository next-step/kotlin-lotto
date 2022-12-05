package lotto.view

class ConsoleInput {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")

        return readNonBlankLn().toIntOrNull() ?: throw IllegalArgumentException("purchase amount should be number")
    }

    fun getWinnerNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningNumbers = readNonBlankLn().takeIf { it.contains(WINNING_NUMBER_DELIMITER) } ?: throw IllegalArgumentException("winning numbers should contain $WINNING_NUMBER_DELIMITER")

        return winningNumbers.split(WINNING_NUMBER_DELIMITER)
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("each winning number should be number") }
    }

    private fun readNonBlankLn() = readln().ifBlank { throw IllegalArgumentException("empty string is not allowed") }

    companion object {
        private const val WINNING_NUMBER_DELIMITER = ","
    }
}
