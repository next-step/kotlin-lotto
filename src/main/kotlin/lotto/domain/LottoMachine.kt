package lotto.domain

import lotto.util.LottoNumberGenerator
import lotto.util.RandomLottoNumberGenerator

class LottoMachine {
    fun generate(lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator): Lotto {
        return Lotto(lottoNumberGenerator.generate())
    }
}
