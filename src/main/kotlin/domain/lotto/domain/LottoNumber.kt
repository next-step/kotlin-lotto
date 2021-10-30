package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberRangeException

@JvmInline
value class LottoNumber private constructor(private val lottoNumber: Int) {
    companion object {
        private const val MINIMUM = 1
        private const val MAXIMUM = 45

        fun of(lottoNumber: Int): LottoNumber {
            if (!((MINIMUM..MAXIMUM).contains(lottoNumber))) {
                throw InvalidLottoNumberRangeException(lottoNumber)
            }
            return LottoNumber(lottoNumber)
        }
    }
}
