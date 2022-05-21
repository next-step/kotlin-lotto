package lotto.util

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): LottoNumbers {
        return LottoNumber.all()
            .shuffled()
            .let { LottoNumbers.from(it) }
    }
}
