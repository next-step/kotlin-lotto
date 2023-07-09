package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class RandomLottoGenerator : LottoGenerator {
    override fun get(): Lotto {
        return LottoNumber.NUMBER_RANGE
            .shuffled()
            .take(Lotto.LOTTO_NUMBER_SIZE)
            .sorted()
            .map(::LottoNumber)
            .let(::Lotto)
    }
}
