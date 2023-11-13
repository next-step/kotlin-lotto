package lotto.business

object LottoTicketExtractor {
    private const val LOTTO_WINNING_NUMBERS_DELIMITER = ","

    fun extractLottoTicket(lottoNumbersString: String): LottoTicket {
        lottoNumbersString.split(LOTTO_WINNING_NUMBERS_DELIMITER)
            .map { checkStringIsInt(it) }
            .map { LottoNumber(it) }
            .toSet()
            .let { return LottoTicket(it) }
    }

    fun extractManualTicketNumbers(manualTicketNumbers: List<String>): List<LottoTicket> {
        return manualTicketNumbers.map(::extractLottoTicket)
    }

    private fun checkStringIsInt(it: String) =
        it.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
}
