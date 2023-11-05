package lotto.controller

class EndLottoRequest(
    val winningNumbers: List<Int>,
) {
    companion object {
        private const val WINNING_NUMBER_DELIMITER = ", "

        fun from(inputNumbers: String): EndLottoRequest {
            val numbers = inputNumbers
                .split(WINNING_NUMBER_DELIMITER)
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다") }
            return EndLottoRequest(numbers)
        }
    }
}
