package lotto.util

interface NumberGenerator {
    fun getNumbers(count: Int): List<Int>
}