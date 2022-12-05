package lotto.model

class Lotto(val value: Set<LottoNumber>) : Set<LottoNumber> by value {
    init {
        check(value.size == 6)
    }

    companion object {
        fun of(value: List<Int>): Lotto {
            return Lotto(value.map { LottoNumber(it) }.toSet())
        }
    }
}
