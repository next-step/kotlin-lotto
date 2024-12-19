package lotto.util

import lotto.domain.LottoNumber

class RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): Set<LottoNumber> {
        return LottoNumber.CACHED_LOTTO_NUMBERS.shuffled().take(6).toSet()
    }
}
