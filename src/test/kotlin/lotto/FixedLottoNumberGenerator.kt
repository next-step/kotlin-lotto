package lotto

import lotto.domain.LottoNumber
import lotto.util.LottoNumberGenerator

class FixedLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(): Set<LottoNumber> {
        return (1..6).map { LottoNumber.getNumber(it) }.toSet()
    }
}
