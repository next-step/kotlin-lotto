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
        fun random(): LottoNumbers = (LottoNumber.START_NUMBER..LottoNumber.LAST_NUMBER)
            .shuffled()
            .take(NUMBERS_COUNT)
            .map(::LottoNumber)
            .toSortedSet()
            .let(::LottoNumbers)

        const val NUMBERS_COUNT = 6
    }
}
