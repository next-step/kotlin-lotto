package lotto.adapter.`in`

class WinningNumbersRequest private constructor(val winningNumbers: List<Int>) {
    companion object {
        private const val WINNING_NUMBER_DELIMITER = ","
        fun from(input: String): WinningNumbersRequest {
            val numbers = input
                .replace(" ", "")
                .split(WINNING_NUMBER_DELIMITER)
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다") }

            return WinningNumbersRequest(numbers)
        }
    }
}
