package lotto.util

interface NumberGenerator<T> {
    fun generateNumbers(count: Int): List<T>
}
