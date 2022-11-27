package lotto.domain

class Lotto(
    val numbers: List<Int>
) {
    init {
        require(numbers.size <= LOTTO_NUMBERS_SIZE) { "로또의 숫자는 6개를 넘을 수 없습니다." }
    }

    fun countHitNumbers(luckyNumbers: List<Int>): Int {
        return numbers.count { number -> luckyNumbers.contains(number) }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
