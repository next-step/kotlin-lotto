package lotto

class LottoNumber private constructor(val numbers: List<Int>) {
    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
        fun generate(): LottoNumber {
            val randomNumbers = (1..LOTTO_NUMBER_SIZE)
                .map { LOTTO_NUMBER_RANGE.random() }
                .sorted()
            return LottoNumber(numbers = randomNumbers)
        }
    }
}
