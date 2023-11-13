package lotto.business

object LottoWinningTicketExtractor {
    private const val LOTTO_WINNING_NUMBERS_DELIMITER = ","

    fun extract(lottoNumbersString: String, bonusNumber: LottoNumber): WinningLottoTicket {
        lottoNumbersString.split(LOTTO_WINNING_NUMBERS_DELIMITER)
            .map { checkStringIsInt(it) }
            .map { LottoNumber(it) }
            .toSet()
            .let { return WinningLottoTicket(LottoTicket(it), bonusNumber) }
    }

    private fun checkStringIsInt(it: String) =
        it.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
}
