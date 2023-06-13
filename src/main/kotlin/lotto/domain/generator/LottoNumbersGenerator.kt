package lotto.domain.generator

import lotto.domain.LottoNumber

fun interface LottoNumbersGenerator {
    fun generate(): LinkedHashSet<LottoNumber>
}
