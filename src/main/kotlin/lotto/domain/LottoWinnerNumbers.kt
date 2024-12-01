package lotto.domain

import lotto.domain.LottoTicket.Companion.INVALID_WINNER_NUMBERS_RANGE_MESSAGE
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MAX_VALUE
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_MIN_VALUE

data class LottoWinnerNumbers(val winnerNumbers: Set<Int>) {
    init {
        require(winnerNumbers.size == LOTTO_NUMBER_COUNT) { INVALID_WINNER_NUMBERS_COUNT_MESSAGE }
        require((LOTTO_NUMBER_MIN_VALUE..LOTTO_NUMBER_MAX_VALUE).toSet().containsAll(winnerNumbers)) {
            INVALID_WINNER_NUMBERS_RANGE_MESSAGE
        }
    }

    companion object {
        const val INVALID_WINNER_NUMBERS_COUNT_MESSAGE: String = "로또 당첨 번호 개수는 6개여야 합니다"
    }
}
