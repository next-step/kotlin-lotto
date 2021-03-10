package lotto.data

data class WinningNumbers(
    val winningNumbers: List<Int>
) {
    init {
        require(winningNumbers.size == 6) { "당첨 숫자의 개수는 6개여야 합니다." }
    }

    fun contains(number: Int): Boolean {
        return winningNumbers.contains(number)
    }
}
