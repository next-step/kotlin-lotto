package lotto.component

import lotto.domain.Lotto
import lotto.domain.LottoNumber

private val LOTTO_NUMBERS = (LottoNumber.START_LOTTO_NUMBER..LottoNumber.END_LOTTO_NUMBER).toList()

object RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): List<LottoNumber> {
        return LOTTO_NUMBERS
            .shuffled()
            .subList(0, Lotto.COUNT_OF_NUMBER)
            .map { LottoNumber.from(it) }
            .toList()
    }
}
