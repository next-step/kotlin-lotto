package lotto.domain.request

import lotto.domain.Lotto
import lotto.domain.WinningInfo.Companion.WINNING_NUMBERS_VALID_LENGTH

data class WinningInfoRequest(val values: List<Int>, val bonusNumber: Int) :
    List<Int> by values {
    init {
        require(values.size == WINNING_NUMBERS_VALID_LENGTH) {
            "Require number size: ${Lotto.VALID_LENGTH}, Input: $values"
        }
    }
}
