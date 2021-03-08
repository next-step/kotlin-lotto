package lotto.data

data class WinningNumbers(
    val winningNumbers: List<Int>
) {
    fun contains(number: Int): Boolean {
        return winningNumbers.contains(number)
    }
}