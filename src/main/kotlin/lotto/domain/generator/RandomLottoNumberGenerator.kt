package lotto.domain.generator

import lotto.domain.LottoNumber

object RandomLottoNumberGenerator : LottoNumberGenerator {
    override fun generate(count: Int): List<LottoNumber> {
        return (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER).toList().shuffled().take(6).map(::LottoNumber)
    }
}
