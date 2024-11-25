package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_MAX_NUMBER
import lotto.domain.Lotto.Companion.LOTTO_MIN_NUMBER
import lotto.domain.Lotto.Companion.LOTTO_NUMBERS_COUNT

object LottoGenerator {
    fun generateTicket(): Lotto {
        val numbers = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).shuffled().take(LOTTO_NUMBERS_COUNT)
        return Lotto.of(numbers)
    }
}
