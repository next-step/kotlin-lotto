package lotto

class WinningNumbers(private val numbers: Set<Int>) {
    fun contains(number: Int): Boolean {
        return number in numbers
    }
}
