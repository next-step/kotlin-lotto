package lotto.test

import lotto.domain.LottoNumber

object LottoNumberGenerator {

    fun generate(vararg numbers: Int): Set<LottoNumber> {
        return numbers.map { LottoNumber(it) }.toSet()
    }
}
