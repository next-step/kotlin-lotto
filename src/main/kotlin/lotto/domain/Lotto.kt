package lotto.domain

class Lotto private constructor(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_COUNT) {
            "A single lotto ticket should have $LOTTO_NUMBERS_COUNT numbers"
        }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            "Lotto numbers should be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER"
        }
    }

    fun getNumbers(): List<Int> = numbers

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_NUMBERS_COUNT = 6

        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers.sorted())
        }
    }
}
