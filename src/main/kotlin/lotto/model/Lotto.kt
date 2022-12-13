package lotto.model

import java.math.BigDecimal

class Lotto(val value: Set<LottoNumber>) : Set<LottoNumber> by value {
    init {
        require(value.size == 6)
    }

    fun getCountThatMatches(other: Lotto): Int {
        return value.count { other.contains(it) }
    }

    companion object {
        val LOTTO_PRICE = BigDecimal(1000)

        fun randomLotto(): Lotto {
            val mutableSet = mutableSetOf<LottoNumber>()
            while (mutableSet.size < 6) {
                val lottoNumber = LottoNumber.random()
                if (mutableSet.contains(lottoNumber)) {
                    continue
                }
                mutableSet.add(lottoNumber)
            }
            return Lotto(mutableSet.toSet())
        }

        fun of(value: List<Int>): Lotto {
            return Lotto(value.map { LottoNumber(it) }.toSet())
        }
    }
}
