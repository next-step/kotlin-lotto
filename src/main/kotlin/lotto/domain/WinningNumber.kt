package lotto.domain

class WinningNumber(
    private val numbers: List<Int>
) {
    init {
        require(numbers.size == WINNING_NUMBER_SIZE) { "당첨번호는 6개여야 합니다." }
    }

    fun contain(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        private const val WINNING_NUMBER_SIZE = 6
    }
}
