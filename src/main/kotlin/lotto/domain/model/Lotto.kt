package lotto.domain.model

@JvmInline
value class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "$MESSAGE_INVALID_LOTTO_NUMBERS_SIZE${numbers.size}"
        }
    }

    fun getNumberOfMatches(other: Lotto): NumberOfMatches = NumberOfMatches((numbers intersect other.numbers).count())

    operator fun contains(lottoNumber: LottoNumber): Boolean = lottoNumber in numbers

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        private const val MESSAGE_INVALID_LOTTO_NUMBERS_SIZE = "로또 번호는 6개의 숫자로 이루어져야 합니다.\n입력된 숫자 수 : "

        fun from(vararg numbers: Int): Lotto {
            return Lotto(
                numbers.map { number ->
                    LottoNumber[number]
                }.toSet()
            )
        }

        fun from(numbers: List<Int>): Lotto {
            return Lotto(
                numbers.map { number ->
                    LottoNumber[number]
                }.toSet()
            )
        }
    }
}
