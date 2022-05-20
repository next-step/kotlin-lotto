package lotto.util

import lotto.domain.LottoNumbers

object RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): LottoNumbers {
        return LottoNumbers.all()
            .shuffled()
            .let { LottoNumbers.from(it) }
    }
}
