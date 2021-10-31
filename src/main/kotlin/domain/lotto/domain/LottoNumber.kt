package domain.lotto.domain

import domain.lotto.error.InvalidLottoNumberRangeException

@JvmInline
value class LottoNumber private constructor(val lottoNumber: Int) : Comparable<LottoNumber> {
    init {
        if (!((MINIMUM..MAXIMUM).contains(lottoNumber))) {
            throw InvalidLottoNumberRangeException(lottoNumber)
        }
    }

    override fun compareTo(other: LottoNumber): Int = lottoNumber.compareTo(other.lottoNumber)

    companion object {
        private val CACHE: Map<Int, LottoNumber> by lazy { (MINIMUM..MAXIMUM).associateWith { LottoNumber(it) } }
        private const val MINIMUM = 1
        private const val MAXIMUM = 45

        fun of(lottoNumber: Int): LottoNumber {
            if (!((MINIMUM..MAXIMUM).contains(lottoNumber))) {
                throw InvalidLottoNumberRangeException(lottoNumber)
            }
            return CACHE.getValue(lottoNumber)
        }

        fun values(): List<LottoNumber> = CACHE.values.toList()
    }
}
