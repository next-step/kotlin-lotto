package lotto.dto

import lotto.domain.Delimiter
import lotto.domain.WinningLottoNumbers

class WinningNumbersInputDto(winningNumbersString: String, bonusBallString: String) {
    val winningLottoTicketNumbers: WinningLottoNumbers =
        WinningLottoNumbers.ofString(winningNumbersString, DELIMITER, bonusBallString)

    companion object {
        private val DELIMITER = Delimiter(",")
    }
}
