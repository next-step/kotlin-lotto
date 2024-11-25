package lotto.const

import lotto.domain.LottoNumber

object LottoConst {
    const val UNIT_OF_AMOUNT = 1000
    val LOTTO_NUMBERS = IntRange(1, 45).map { LottoNumber(it) }.toList()
}
