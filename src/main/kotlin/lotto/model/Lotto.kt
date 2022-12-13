package lotto.model

import java.math.BigDecimal

class Lotto private constructor(val value: Set<LottoNumber>) : Set<LottoNumber> by value {
    init {
        require(value.size == LOTTO_NUMBER_COUNT)
    }

    fun matchCount(other: Lotto): Int {
        return value.count(other::contains)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        val LOTTO_PRICE = BigDecimal(1000)

        fun of(vararg values: Int): Lotto {
            return values.map(LottoNumber::of)
                .toSet()
                .let(::Lotto)
        }

        fun of(lottoNumbers: List<LottoNumber>): Lotto {
            return lottoNumbers
                .toSet()
                .let(::Lotto)
        }
    }
}
