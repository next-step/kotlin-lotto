package lotto

class WinningNumbers(private val numbers: List<Int>) {
    fun contains(number: Int): Boolean {
        return number in numbers
    }
}
