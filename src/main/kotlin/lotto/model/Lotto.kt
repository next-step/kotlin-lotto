package lotto.model

class Lotto(val value: Set<LottoNumber>) : Set<LottoNumber> by value {
    init {
        require(value.size == 6)
    }

    companion object {
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
