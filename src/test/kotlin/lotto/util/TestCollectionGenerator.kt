package lotto.util

import lotto.domain.Lotto
import lotto.domain.LottoNumber

fun lottoNumberSetOf(vararg numbers: Int): Set<LottoNumber> {
    return numbers.map(::LottoNumber).toSet()
}

fun lottoOf(vararg numbers: Int): Lotto {
    return Lotto.of(numbers.toSet())
}
