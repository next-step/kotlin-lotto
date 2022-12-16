package lotto

class LottoNumber private constructor(val numbers: List<Int>) {
    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
        fun generate(): LottoNumber {
            val numberSet = mutableSetOf<Int>()
            while (numberSet.size < LOTTO_NUMBER_SIZE) {
                val randomNumber = LOTTO_NUMBER_RANGE.random()
                numberSet.add(randomNumber)
            }
            val randomNumbers = numberSet.toList().sorted()
            return LottoNumber(numbers = randomNumbers)
        }
    }
}
