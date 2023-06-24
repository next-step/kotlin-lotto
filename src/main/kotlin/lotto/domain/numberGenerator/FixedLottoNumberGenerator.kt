package lotto.domain.numberGenerator

import lotto.domain.LottoNumber

class FixedLottoNumberGenerator(private val fixedNumbers: List<Int>) : LottoNumberGenerator {

    override fun generateNumbers(): List<LottoNumber> {
        return fixedNumbers.map { LottoNumber(it) }
    }
}
