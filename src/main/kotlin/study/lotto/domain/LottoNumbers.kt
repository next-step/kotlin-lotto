package study.lotto.domain

class LottoNumbers(private val numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {
    init {
        require(numbers.isNotEmpty()) {
            "LottoNumbers cannot be empty"
        }
        require(numbers.size == NUMBERS_COUNT) {
            "LottoNumbers size must be equal to $NUMBERS_COUNT"
        }
    }

    companion object {

        private val lottoNumberList = (LottoNumber.START_NUMBER..LottoNumber.LAST_NUMBER).map(::LottoNumber)
        const val NUMBERS_COUNT = 6

        fun get(vararg numbers: Int) = numbers
            .map(::LottoNumber)
            .toSortedSet()
            .let(::LottoNumbers)

        fun random(): LottoNumbers = lottoNumberList
            .shuffled()
            .take(NUMBERS_COUNT)
            .toSortedSet()
            .let(::LottoNumbers)

        fun get(intList: List<Int>) = intList
            .map(::LottoNumber)
            .toSortedSet()
            .let(::LottoNumbers)
    }
}
