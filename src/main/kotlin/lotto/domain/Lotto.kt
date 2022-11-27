package lotto.domain

class Lotto(
    val numbers: List<Int>
) {
    fun countHitNumbers(luckyNumbers: List<Int>): Int {
        return numbers.count { number -> luckyNumbers.contains(number) }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
