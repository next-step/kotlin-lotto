package lotto.generator

import lotto.Lotto
import lotto.LottoNumber

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
