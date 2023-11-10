package lotto.util

interface NumberGenerator {
    fun generate(min: Int, max: Int, count: Int): List<Int>
}
