package lotto.fixture

import lotto.domain.LottoNumber
import lotto.domain.LottoNumberGenerator

internal class FixedLottoNumberGenerator(
    private val numbers: List<Int>,
) : LottoNumberGenerator {
    override fun generate(): List<LottoNumber> {
        return numbers.map(::LottoNumber)
    }
}
