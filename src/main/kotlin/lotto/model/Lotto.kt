package lotto.model

class Lotto(val value: List<LottoNumber>) : List<LottoNumber> by value {
    companion object {
        fun of(i: Int, i1: Int, i2: Int, i3: Int, i4: Int, i5: Int): Lotto {
            return Lotto(listOf())
        }
    }
}
