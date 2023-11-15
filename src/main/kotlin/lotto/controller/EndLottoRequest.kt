package lotto.controller

class EndLottoRequest(
    val winningNumbers: List<Int>,
    val bonusNumber: Int,
) {
    companion object {
        private const val WINNING_NUMBER_DELIMITER = ", "

        fun from(
            winningNumbers: String,
            bonusNumber: String,
        ): EndLottoRequest = EndLottoRequest(
            winningNumbers = parseWinningNumbers(winningNumbers),
            bonusNumber = parseBonusNumber(bonusNumber),
        )

        private fun parseWinningNumbers(winningNumbers: String) = winningNumbers
            .split(WINNING_NUMBER_DELIMITER)
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다") }

        private fun parseBonusNumber(bonusNumber: String) = bonusNumber.toIntOrNull()
            ?: throw IllegalArgumentException("보너스볼 번호는 숫자여야 합니다")
    }
}
