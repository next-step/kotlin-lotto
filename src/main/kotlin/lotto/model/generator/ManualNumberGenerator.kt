package lotto.model.generator

import lotto.model.lotto.Numbers

class ManualNumberGenerator(
    private val numbers: Numbers
) : LottoNumberGenerator {
    override fun generate() = numbers
}
