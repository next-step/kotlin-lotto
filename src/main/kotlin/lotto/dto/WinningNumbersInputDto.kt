package lotto.dto

import lotto.domain.LottoTicketNumbers

class WinningNumbersInputDto(winningNumbersString: String) {
    val winningLottoTicketNumbers: LottoTicketNumbers = LottoTicketNumbers.ofString(winningNumbersString, DELIMITERS)

    companion object {
        private const val DELIMITERS = ","
    }
}
