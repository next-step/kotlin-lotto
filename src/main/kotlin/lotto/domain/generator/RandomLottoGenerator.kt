package lotto.domain.generator

import lotto.domain.GenerationType
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

class RandomLottoGenerator : LottoGenerator {
    override fun get(): Lotto {
        return LottoNumber.NUMBER_RANGE
            .shuffled()
            .take(LottoNumbers.LOTTO_NUMBER_SIZE)
            .sorted()
            .map(::LottoNumber)
            .let { Lotto(LottoNumbers(it), GenerationType.AUTO) }
    }
}
