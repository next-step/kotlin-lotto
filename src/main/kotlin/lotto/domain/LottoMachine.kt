package lotto.domain

import lotto.util.LottoNumberGenerator
import lotto.util.RandomLottoNumberGenerator

class LottoMachine {
    fun generate(lottoNumber: LottoNumbers): Lotto {
        return Lotto.of(lottoNumber)
    }

    fun generate(lottoNumberGenerator: LottoNumberGenerator = RandomLottoNumberGenerator): Lotto {
        return Lotto.of(lottoNumberGenerator.generate(), true)
    }
}
