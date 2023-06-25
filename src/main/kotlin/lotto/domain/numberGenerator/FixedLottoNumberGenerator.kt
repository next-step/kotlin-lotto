package lotto.domain.numberGenerator

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberPool

class FixedLottoNumberGenerator(private val fixedNumbers: List<Int>) : LottoNumberGenerator {

    override fun generateNumbers(): List<LottoNumber> {
        return fixedNumbers.map { LottoNumberPool.get(it) }
    }
}
