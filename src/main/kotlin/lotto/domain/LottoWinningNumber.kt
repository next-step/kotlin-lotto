package lotto.domain

data class LottoWinningNumber(
    val winningNumbers: LottoLine,
    val bonusNumber: LottoNumber
) {
    companion object {
        private const val WINNING_NUMBER_DELIMITER = ", "
        fun of(winningNumber: String, bonusNumber: String): LottoWinningNumber {
            val parsedNumbers = winningNumber.split(WINNING_NUMBER_DELIMITER)
                .mapNotNull { it.toIntOrNull() }
            require(parsedNumbers.size == 6) {
                "당첨 번호를 \"$WINNING_NUMBER_DELIMITER\" 기준으로 6개의 숫자를 입력하여 주세요."
            }

            val bonusNumberToInt = bonusNumber.toIntOrNull()
            require(bonusNumberToInt != null && bonusNumberToInt > 0) {
                "보너스 번호는 양수로 입력하여 주세요. "
            }
            return LottoWinningNumber(LottoLine(parsedNumbers.map(::LottoNumber)), LottoNumber(bonusNumberToInt))
        }
    }
}
