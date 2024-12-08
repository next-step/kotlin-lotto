package lotto.util

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

fun createLottoNumbers(vararg numbers: Int): LottoNumbers {
    return LottoNumbers(numbers.map { LottoNumber.of(it) }.toSet())
}
