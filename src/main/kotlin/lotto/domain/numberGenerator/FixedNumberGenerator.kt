package lotto.domain.numberGenerator

import lotto.domain.LottoNumber

class FixedNumberGenerator(private val fixedNumbers: List<Int>) : NumberGenerator {

    override fun generateNumbers(): List<LottoNumber> {
        return fixedNumbers.map { LottoNumber(it) }
    }
}
