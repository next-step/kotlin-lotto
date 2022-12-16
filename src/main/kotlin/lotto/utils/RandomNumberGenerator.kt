package lotto.utils

object RandomNumberGenerator {
    fun generate(range: IntRange): Int = range.random()
}
