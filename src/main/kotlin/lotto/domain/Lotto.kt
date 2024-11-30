package lotto.domain

class Lotto private constructor(private val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_COUNT) {
            "A single lotto ticket should have $LOTTO_NUMBERS_COUNT numbers"
        }
    }

    fun countMatchingNumbers(other: Lotto): Int {
        return numbers.count { it in other.numbers }
    }

    fun hasNumber(number: LottoNumber): Boolean {
        return numbers.contains(number)
    }

    fun getNumbers(): List<LottoNumber> = numbers

    companion object {
        const val LOTTO_NUMBERS_COUNT = 6

        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber.of(it) }.sortedBy { it.number })
        }
    }
}
