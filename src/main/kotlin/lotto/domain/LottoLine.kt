package lotto.domain

data class LottoLine(
    val line: List<LottoNumber>
) {
    fun getSameNumberCount(winningNumbers: LottoLine) = line.count { winningNumbers.line.contains(it) }
    fun isContainsBonusNumber(bonusNumber: LottoNumber) = line.contains(bonusNumber)

    companion object {
        const val LOTTO_NUMBER_DELIMITER = ", "
        fun valueOf(numberLine: String): LottoLine {
            val parsedNumbers = numberLine.split(LOTTO_NUMBER_DELIMITER)
                .mapNotNull { it.toIntOrNull() }
            require(parsedNumbers.size == 6) {
                "당첨 번호를 \"${LOTTO_NUMBER_DELIMITER}\" 기준으로 6개의 숫자를 입력하여 주세요."
            }

            return LottoLine(parsedNumbers.map(LottoNumber::from))
        }
    }
}
