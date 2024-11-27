package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber

fun createLotto(vararg numbers: Int): Lotto {
    return Lotto(numbers.map { LottoNumber(it) }.toSet())
}
