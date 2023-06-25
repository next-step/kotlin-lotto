package lotto.domain

class Numbers(val values: List<Int>) {
    init {
        require(values.size == LOTTO_SIZE)
    }

    fun countMatchingNumbers(winningNumbers: List<Int>) =
        values.count { winningNumbers.contains(it) }
}