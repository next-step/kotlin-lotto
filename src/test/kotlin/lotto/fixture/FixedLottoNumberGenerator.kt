package lotto.fixture

import lotto.LottoNumber
import lotto.LottoNumberGenerator

internal class FixedLottoNumberGenerator(
    private val numbers: List<Int>,
) : LottoNumberGenerator {
    override fun generate(): List<LottoNumber> {
        return numbers.map(::LottoNumber)
    }
}
