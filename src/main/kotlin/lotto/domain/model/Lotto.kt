package lotto.domain.model

@JvmInline
value class Lotto private constructor(val numbers: Set<LottoNumber>) {
    fun getNumberOfMatches(other: Lotto): NumberOfMatches = NumberOfMatches((numbers intersect other.numbers).count())

    operator fun contains(lottoNumber: LottoNumber): Boolean = lottoNumber in numbers

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun from(vararg numbers: Int): Lotto {
            return Lotto(
                numbers.map { number ->
                    LottoNumber[number]
                }.toSet()
            )
        }

        fun from(numbers: Set<LottoNumber>?): Lotto? {
            return if (numbers?.size == LOTTO_NUMBER_COUNT) Lotto(numbers) else null
        }
    }
}
