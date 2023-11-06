package lotto.business

object LottoWinningNumbersExtractor {
    private const val LOTTO_WINNING_NUMBERS_DELIMITER = ","

    fun extract(lottoNumbersString: String): LottoWinningNumbers {
        lottoNumbersString.split(LOTTO_WINNING_NUMBERS_DELIMITER)
            .map { checkStringIsInt(it) }
            .map { LottoNumber(it) }
            .toSet()
            .let { return LottoWinningNumbers(it) }
    }

    private fun checkStringIsInt(it: String) = it.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
}
