package lotto.domain

class WinningNumbers(val numbers: List<Int>) {
    fun isInWinningNumbers(number: Int): Boolean {
        return numbers.contains(number)
    }
}
