package lotto.util

interface NumberGenerator {
    fun generate(start: Int, end: Int, size: Int): List<Int>
}
