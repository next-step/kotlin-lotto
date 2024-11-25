package lotto.domain

import lotto.domain.LottoRule.LOTTO_NUMBER_MAX
import lotto.domain.LottoRule.LOTTO_NUMBER_MIN

@JvmInline
value class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { "로또 번호는 ${LOTTO_NUMBER_MIN}부터 ${LOTTO_NUMBER_MAX} 사이여야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value - other.value
    }
}
