package lotto.domain

data class LottoLine(
    val line: List<LottoNumber>
) {
    fun getSameNumberCount(lottoLine: LottoLine) = line.count { lottoLine.isContainsNumber(it) }
    fun isContainsNumber(lottoNumber: LottoNumber) = line.contains(lottoNumber)

    companion object {
        private const val LOTTO_NUMBER_DELIMITER = ", "
        private const val LOTTO_LINE_NUMBER_QUANTITY = 6
        fun valueOf(numberLine: String): LottoLine {
            val parsedNumbers = numberLine.split(LOTTO_NUMBER_DELIMITER)
                .mapNotNull { it.toIntOrNull() }
            require(parsedNumbers.size == LOTTO_LINE_NUMBER_QUANTITY) {
                "당첨 번호를 \"${LOTTO_NUMBER_DELIMITER}\" 기준으로 6개의 숫자를 입력하여 주세요."
            }

            return LottoLine(parsedNumbers.map(LottoNumber::from))
        }

        fun generate(): LottoLine = LottoLine((1..LOTTO_LINE_NUMBER_QUANTITY).map { LottoNumber.random() })
    }
}
