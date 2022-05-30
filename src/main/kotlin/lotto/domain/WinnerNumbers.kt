package lotto.domain

class WinnerNumbers(private val numbers: List<Int>) {
    init {
        require(numbers.all { Lotto.LOTTO_NUMBER_RANGE.contains(it) })
    }

    fun count(f: (number: Int) -> Boolean): Int {
        return numbers.count(f)
    }
}
