package lotto.domain

class WinningNumbers(
    val numbers: List<Int>,
) {
    fun matchNumbers(lotto: Lotto): Int {
        return lotto.numbers.filter { isInWinningNumbers(it) }.size
    }

    private fun isInWinningNumbers(number: Int): Boolean {
        return numbers.contains(number)
    }
}
