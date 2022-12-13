package lotto.model

import java.math.BigDecimal

class Lotto(val value: Set<LottoNumber>) : Set<LottoNumber> by value {
    init {
        require(value.size == LOTTO_NUMBER_COUNT)
    }

    fun getCountThatMatches(other: Lotto): Int {
        return value.count { other.contains(it) }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        val LOTTO_PRICE = BigDecimal(1000)

        fun of(value: List<Int>): Lotto {
            return Lotto(value.map { LottoNumber.of(it) }.toSet())
        }

        fun ofList(lottoNumbers: List<LottoNumber>): Lotto {
            return Lotto(lottoNumbers.toSet())
        }
    }
}
