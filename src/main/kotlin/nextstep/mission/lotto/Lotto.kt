package nextstep.mission.lotto

private fun Int.increaseIf(predicate: () -> Boolean) = when {
    predicate() -> this.inc()
    else -> this
}

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 숫자는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "로또 숫자는 중복이 허용되지 않습니다." }
        requireRange(numbers.toMutableList())
    }

    private tailrec fun requireRange(numbers: MutableList<Int>) {
        when {
            numbers.isEmpty() -> return
            isInvalidRange(numbers.removeFirst()) -> throw IllegalArgumentException("로또 숫자는 1에서 45사이어야 합니다.")
            else -> requireRange(numbers)
        }
    }

    private fun isInvalidRange(number: Int): Boolean = (number < 1) or (number > 45)

    fun checkWinningNumbers(winningNumbers: List<Int>): Int {
        tailrec fun checkWinningNumbers(
            winningCount: Int,
            numbers: MutableList<Int>,
            winningNumbers: List<Int>,
        ): Int = when {
            numbers.isEmpty() -> winningCount
            else -> {
                checkWinningNumbers(
                    winningCount.increaseIf { winningNumbers.contains(numbers.removeFirst()) },
                    numbers,
                    winningNumbers
                )
            }
        }
        return checkWinningNumbers(0, this.numbers.toMutableList(), winningNumbers)
    }
}
