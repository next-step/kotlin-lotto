package study.lotto.domain

class LottoNumbers(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        require(numbers.isNotEmpty()) {
            "LottoNumbers cannot be empty"
        }
        require(numbers.size == NUMBERS_COUNT) {
            "LottoNumbers size must be equal to $NUMBERS_COUNT"
        }
        require(numbers.all { it.number in LottoNumber.START_NUMBER..LottoNumber.LAST_NUMBER }) {
            "All Lotto numbers must be in the range ${LottoNumber.START_NUMBER} to ${LottoNumber.LAST_NUMBER}"
        }
    }

    companion object {
        const val NUMBERS_COUNT = 6
    }
}
