package lotto.dto

import lotto.domain.WinningLottoNumbers

class WinningNumbersInputDto(winningNumbersString: String, bonusBallString: String) {
    val winningLottoTicketNumbers: WinningLottoNumbers =
        WinningLottoNumbers.ofString(winningNumbersString, DELIMITERS, bonusBallString)

    companion object {
        private const val DELIMITERS = ","
    }
}
