package lotto

import lotto.domain.LottoNumber
import lotto.util.LottoNumberGenerator

class FixedLottoNumberGenerator(private val lottoNumbers: List<Int>) : LottoNumberGenerator {
    override fun generate(): Set<LottoNumber> {
        return lottoNumbers.map { LottoNumber.getNumber(it) }.toSet()
    }
}
