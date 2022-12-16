package lotto

class WinningNumber private constructor(
    val numbers: List<Int>,
) {
    companion object {
        private const val WINNING_NUMBER_SIZE = 6
        private val WINNING_NUMBER_RANGE = (1..45)

        fun from(numbers: List<Int>): WinningNumber {
            require(numbers.size == WINNING_NUMBER_SIZE)
            require(numbers.toSet().size == WINNING_NUMBER_SIZE)
            require(numbers.all { WINNING_NUMBER_RANGE.contains(it) })
            return WinningNumber(numbers = numbers)
        }
    }
}
