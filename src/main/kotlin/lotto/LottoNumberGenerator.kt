package lotto

import lotto.LottoNumber.Companion.LOTTO_NUMBER_RANGE
import lotto.LottoNumber.Companion.LOTTO_NUMBER_SIZE

object LottoNumberGenerator {

    fun generate(): LottoNumber {
        return LottoNumber(LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_SIZE))
    }
}
