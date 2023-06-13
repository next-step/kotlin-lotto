package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object RandomLottoNumbersGenerator : LottoNumbersGenerator {
    private const val START_INDEX = 0

    override fun generate(): Set<LottoNumber> =
        LottoNumber.all().shuffled()
            .subList(START_INDEX, Lotto.VALID_LENGTH)
            .toSet()
}
