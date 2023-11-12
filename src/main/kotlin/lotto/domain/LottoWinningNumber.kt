package lotto.domain

data class LottoWinningNumber(
    val winningNumbers: LottoLine,
    val bonusNumber: LottoNumber
) {
    companion object {
        fun of(winningNumber: String, bonusNumber: String): LottoWinningNumber {
            val winningNumbers = LottoLine.valueOf(winningNumber)
            val bonusNumberToInt = bonusNumber.toIntOrNull()
            require(bonusNumberToInt != null && bonusNumberToInt > 0) {
                "보너스 번호는 양수로 입력하여 주세요. "
            }
            return LottoWinningNumber(winningNumbers, LottoNumber.from(bonusNumberToInt))
        }
    }
}
