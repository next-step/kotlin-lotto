package lotto.domain

import lotto.domain.LottoConstants.LOTTO_SIZE
import lotto.domain.LottoConstants.MAX_LOTTO_NUMBER
import lotto.domain.LottoConstants.MIN_LOTTO_NUMBER

object LottoRandomGenerator {
    fun randomGenerate(): Lotto {
        return Lotto((1..LOTTO_SIZE).map { LottoNumber((MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).random()) })
    }
}
