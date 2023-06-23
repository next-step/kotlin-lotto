package lotto.domain

class WinningNumbers(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == SIZE)
    }

    companion object {
        const val SIZE = 6
    }
}