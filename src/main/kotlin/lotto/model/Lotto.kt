package lotto.model

import java.math.BigDecimal

class Lotto private constructor(val value: Set<LottoNumber>) : Set<LottoNumber> by value {
    init {
        require(value.size == LOTTO_NUMBER_COUNT) {
            "로또를 구성하는 숫자는 ${LOTTO_NUMBER_COUNT}개여야 합니다. value.size: ${value.size}"
        }
    }

    fun matchCountWith(other: Lotto): Int {
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
