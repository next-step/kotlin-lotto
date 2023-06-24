package lotto.domain.numberGenerator

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberPool

class RandomLottoNumberGenerator : LottoNumberGenerator {

    override fun generateNumbers(): List<LottoNumber> {
        return LottoNumberPool.getRandomNumbers()
    }
}
