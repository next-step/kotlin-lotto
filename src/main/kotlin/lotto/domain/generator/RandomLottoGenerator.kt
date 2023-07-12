package lotto.domain.generator

import lotto.domain.GenerateType
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.TypeLotto

class RandomLottoGenerator : LottoGenerator {
    override fun get(): TypeLotto {
        return LottoNumber.NUMBER_RANGE
            .shuffled()
            .take(Lotto.LOTTO_NUMBER_SIZE)
            .sorted()
            .map(::LottoNumber)
            .let { TypeLotto(Lotto(it), GenerateType.AUTO) }
    }
}
