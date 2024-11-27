package lotto.domain

import lotto.domain.LottoRule.LOTTO_NUMBER_MAX
import lotto.domain.LottoRule.LOTTO_NUMBER_MIN

@JvmInline
value class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {
    companion object {
        private val NUMBERS: Map<Int, LottoNumber> =
            (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX)
                .associateWith(::LottoNumber)

        fun of(value: Int): LottoNumber {
            return NUMBERS[value]
                ?: throw IllegalArgumentException("로또 번호는 ${LOTTO_NUMBER_MIN}부터 $LOTTO_NUMBER_MAX 사이여야 합니다.")
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value - other.value
    }
}
