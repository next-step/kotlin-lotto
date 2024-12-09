package lotto

import lotto.LottoConstants.LOTTO_SIZE
import lotto.LottoConstants.MAX_LOTTO_NUMBER
import lotto.LottoConstants.MIN_LOTTO_NUMBER

object LottoRandomGenerator {
    fun randomGenerate(): Lotto {
        return Lotto((1..LOTTO_SIZE).map { LottoNumber((MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).random()) })
    }
}
