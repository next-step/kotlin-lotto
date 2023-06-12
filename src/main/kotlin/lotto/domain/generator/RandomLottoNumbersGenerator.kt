package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object RandomLottoNumbersGenerator : LottoNumbersGenerator {
    private const val START_INDEX = 0

    override fun generate(): LinkedHashSet<LottoNumber> =
        (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).shuffled()
            .subList(START_INDEX, Lotto.VALID_LENGTH)
            .map(LottoNumber::valueOf)
            .toCollection(LinkedHashSet())
}
