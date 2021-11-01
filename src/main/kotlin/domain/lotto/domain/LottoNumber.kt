package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberRangeException

@JvmInline
value class LottoNumber private constructor(val lottoNumber: Int) : Comparable<LottoNumber> {
    init {
        validateLottoNumberRange(lottoNumber)
    }

    override fun compareTo(other: LottoNumber): Int = lottoNumber.compareTo(other.lottoNumber)

    companion object {
        private val CACHE: Map<Int, LottoNumber> by lazy { (MINIMUM..MAXIMUM).associateWith { LottoNumber(it) } }
        private const val MINIMUM = 1
        private const val MAXIMUM = 45

        fun of(lottoNumber: Int): LottoNumber {
            validateLottoNumberRange(lottoNumber)
            return CACHE.getValue(lottoNumber)
        }

        fun values(): List<LottoNumber> = CACHE.values.toList()

        private fun validateLottoNumberRange(lottoNumber: Int) {
            if (!((MINIMUM..MAXIMUM).contains(lottoNumber))) {
                throw InvalidLottoNumberRangeException(lottoNumber)
            }
        }
    }
}
