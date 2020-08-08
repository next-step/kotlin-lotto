package model

class Lotto(override val number: List<LottoNumber>) : BasicLotto {
    companion object {
        const val SIZE = 6

        fun make(): Lotto {
            val lottoNumberList = IntRange(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER).shuffled().take(SIZE).map { LottoNumber.from(it) }
            return Lotto(lottoNumberList)
        }
    }
}
