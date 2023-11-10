package lotto.domain

data class LottoWinningNumber(
    val winningNumbers: List<Int>,
    val bonusNumber: Int
) {
    companion object {
        fun of(winningNumber: String, bonusNumber: String): LottoWinningNumber {
            val parsedNumbers = winningNumber.split(", ")
                .mapNotNull { it.toIntOrNull() }
            require(parsedNumbers.size == 6) {
                "당첨 번호를 ', ' 기준으로 6개의 숫자를 입력하여 주세요."
            }

            val bonusNumberToInt = bonusNumber.toIntOrNull()
            require(bonusNumberToInt != null && bonusNumberToInt > 0) {
                "보너스 번호는 양수로 입력하여 주세요. "
            }
            return LottoWinningNumber(parsedNumbers, bonusNumberToInt)
        }
    }
}
