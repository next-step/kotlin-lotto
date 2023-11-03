package lotto.test

import lotto.domain.LottoNumber

object LottoNumberGenerator {

    fun generate(vararg numbers: Int): List<LottoNumber> {
        return numbers.map { LottoNumber(it) }
    }
}
