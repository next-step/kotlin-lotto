package lotto.domain

class WinningNumbers(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == WINNING_NUMBER_SIZE) { "당첨번호는 6개여야 합니다." }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        private const val WINNING_NUMBER_SIZE = 6
    }
}
