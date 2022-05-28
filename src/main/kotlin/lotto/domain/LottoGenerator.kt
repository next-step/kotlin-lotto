package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBER_COUNT

class LottoGenerator {
    fun generateNumbers(): List<LottoNumber> {
        return LOTTO_NUMBER_RANGE
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) }
    }
}
