package lotto.domain

class Lotto private constructor(private var numbers: List<Int>) {

    fun getLottoNumbers(): List<Int> {
        return numbers.toList()
    }

    companion object {
        private const val MAX_DIGITS = 6
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        fun generateAuto(): Lotto {
            val numbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().slice(0..5)
            return Lotto(numbers.sorted())
        }

        fun generateManual(numbers: List<Int>): Lotto {
            return Lotto(numbers.sorted())
        }
    }
}
