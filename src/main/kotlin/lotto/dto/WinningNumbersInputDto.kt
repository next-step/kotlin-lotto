package lotto.dto

import lotto.domain.Delimiter
import lotto.domain.LottoTicketNumber
import lotto.domain.LottoTicketNumbers
import lotto.domain.WinningLottoNumbers

class WinningNumbersInputDto(winningNumbersString: String, bonusBallString: String) {
    val winningLottoTicketNumbers: WinningLottoNumbers =
        WinningLottoNumbers(
            LottoTicketNumbers.ofInts(DEFAULT_DELIMITER.parseNumbers(winningNumbersString)),
            LottoTicketNumber.ofString(bonusBallString)
        )

    companion object {
        private val DEFAULT_DELIMITER = Delimiter(",")
    }
}
