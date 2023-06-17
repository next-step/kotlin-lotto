package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object FixedLottoGenerator : LottoGenerator {
    override fun getLotto(): Lotto {
        return Lotto((LottoNumber.LOTTO_MIN_NUMBER until LottoNumber.LOTTO_MIN_NUMBER + Lotto.LOTTO_NUMBER_SIZE).toSet())
    }
}
