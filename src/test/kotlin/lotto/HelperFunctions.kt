package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber

fun createLotto(vararg numbers: Int): Lotto {
    return Lotto.from(numbers.map { LottoNumber.getNumber(it) }.toSet())
}

fun createLottoNumberSet(vararg numbers: Int): Set<LottoNumber> {
    return numbers.map { LottoNumber.getNumber(it) }.toSet()
}
