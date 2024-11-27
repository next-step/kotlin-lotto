package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBERS_COUNT
import lotto.domain.LottoNumber.Companion.LOTTO_MAX_NUMBER
import lotto.domain.LottoNumber.Companion.LOTTO_MIN_NUMBER

class RandomLottoGenerator : LottoGenerator {
    override fun generateTicket(): Lotto {
        val numbers = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).shuffled().take(LOTTO_NUMBERS_COUNT)
        return Lotto.of(numbers)
    }
}
