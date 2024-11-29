package lotto

import lotto.LottoConstants.LOTTO_SIZE
import lotto.LottoConstants.MAX_LOTTO_NUMBER
import lotto.LottoConstants.MIN_LOTTO_NUMBER

class LottoRandomGenerator {

    fun randomGenerate(): Lotto {
        return Lotto((MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().take(LOTTO_SIZE))
    }
}
