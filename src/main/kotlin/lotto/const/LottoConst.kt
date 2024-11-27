package lotto.const

import lotto.domain.LottoNumber

object LottoConst {
    const val UNIT_OF_AMOUNT = 1000
    val LOTTO_NUMBERS = IntRange(1, 45).map { LottoNumber(it) }.toList()

    fun getLottoNumber(number: Int): LottoNumber {
        return requireNotNull(LOTTO_NUMBERS.find { it == LottoNumber(number) }) { "일치하는 번호의 로또번호가 존재하지 않습니다." }
    }
}
