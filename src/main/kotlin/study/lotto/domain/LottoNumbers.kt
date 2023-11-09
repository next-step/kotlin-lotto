package study.lotto.domain

class LottoNumbers(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        require(numbers.isNotEmpty()) {
            "LottoNumbers cannot be empty"
        }
        require(numbers.size == NUMBERS_COUNT) {
            "LottoNumbers size must be equal to $NUMBERS_COUNT"
        }
    }

    companion object {
        const val NUMBERS_COUNT = 6
    }
}
