package lotto.domain

class WinningNumbers(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == LOTTO_SIZE)
    }
}