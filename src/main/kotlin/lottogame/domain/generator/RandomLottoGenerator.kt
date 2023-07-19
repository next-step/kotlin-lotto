package lottogame.domain.generator

import lottogame.domain.lotto.GenerationType
import lottogame.domain.lotto.Lotto
import lottogame.domain.lotto.LottoNumber
import lottogame.domain.lotto.LottoNumbers

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
