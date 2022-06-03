package lotto.domain.generator

import lotto.domain.LottoNumber

interface LottoNumberGenerator {
    fun generate(count: Int): List<LottoNumber>
}
