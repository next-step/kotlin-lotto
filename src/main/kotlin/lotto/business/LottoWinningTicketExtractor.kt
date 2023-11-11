package lotto.business

object LottoWinningTicketExtractor {
    private const val LOTTO_WINNING_NUMBERS_DELIMITER = ","

    fun extract(lottoNumbersString: String): WinningLottoTicket {
        lottoNumbersString.split(LOTTO_WINNING_NUMBERS_DELIMITER)
            .map { checkStringIsInt(it) }
            .map { LottoNumber(it) }
            .toSet()
            .let { return WinningLottoTicket(it) }
    }

    private fun checkStringIsInt(it: String) = it.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
}
