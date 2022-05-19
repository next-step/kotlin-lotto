package lotto.util

import lotto.domain.LottoNumbers

object RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): List<Int> {
        return (LottoNumbers.LOTTO_MIN_NUMBER..LottoNumbers.LOTTO_MAX_NUMBER)
            .shuffled()
            .take(LottoNumbers.LOTTO_NUMBER_SIZE)
    }
}
